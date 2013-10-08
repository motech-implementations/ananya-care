package org.dwQueryBuilder.builders.query.helpers;

import org.dwQueryBuilder.data.DwQueryCombination;
import org.dwQueryBuilder.data.enums.CombineType;
import org.dwQueryBuilder.data.DwQuery;
import org.dwQueryBuilder.exceptions.QueryBuilderRuntimeException;
import org.jooq.DSLContext;
import org.jooq.Select;
import org.jooq.SelectConditionStep;
import org.jooq.SelectHavingConditionStep;
import org.jooq.SelectJoinStep;
import org.jooq.SelectSelectStep;

import static org.jooq.impl.DSL.tableByName;

public final class DwQueryHelper {

    private DwQueryHelper() {

    }

    public static Select buildFromDwQuery(DSLContext dslContext, String schemaName, DwQuery dwQuery) {
        try {
            SelectSelectStep selectSelectStep = dslContext.select();
            SelectColumnHelper.buildSelectColumns(schemaName, selectSelectStep, dwQuery);

            SelectHavingConditionStep selectHavingConditionStep = null;
            if (dwQuery.getGroupBy() != null) {
                selectHavingConditionStep = GroupByHelper
                        .buildGroupBy(schemaName, dwQuery, selectSelectStep, dwQuery.getGroupBy());
            }

            selectSelectStep = (selectHavingConditionStep != null)
                    ? (SelectSelectStep) selectHavingConditionStep
                    : selectSelectStep;
            Select select = null;

            SelectConditionStep selectConditionStep = buildFromQuery(schemaName, selectSelectStep, dwQuery);
            if (dwQuery.getLimit() != null) {
                select = selectConditionStep.limit(dwQuery.getLimit());
            }
            select = chooseSelectStep(select, selectConditionStep, selectHavingConditionStep, selectSelectStep);
            select = buildCombineWithStep(dslContext, schemaName, dwQuery, select, dwQuery.getTableName());

            return select;
        } catch (Exception e) {
            throw new QueryBuilderRuntimeException(e);
        }
    }

    public static Select buildCombineWithStep(DSLContext dslContext,
                                            String schemaName,
                                            DwQuery dwQuery,
                                            Select select,
                                            String tableName) {
        Select newSelect = select;

        if (dwQuery.getCombineWith() != null) {
            for (DwQueryCombination dwQueryCombination : dwQuery.getCombineWith()) {
                if (!dwQueryCombination.getCombineType().equals(CombineType.Join)) {
                    continue;
                }

                newSelect = CombinationHelper.buildCombineWith(
                        dslContext, schemaName, newSelect, dwQueryCombination, tableName);
            }
            for (DwQueryCombination dwQueryCombination : dwQuery.getCombineWith()) {
                if (dwQueryCombination.getCombineType().equals(CombineType.Join)) {
                    continue;
                }

                newSelect = CombinationHelper.buildCombineWith(
                        dslContext, schemaName, newSelect, dwQueryCombination, tableName);
            }
        }

        return newSelect;
    }

    public static Select chooseSelectStep(Select select, SelectConditionStep selectConditionStep,
                                           SelectHavingConditionStep selectHavingConditionStep,
                                           SelectSelectStep selectSelectStep) {
        Select newSelect = select;

        if (newSelect == null) {
            if (selectConditionStep != null) {
                newSelect = selectConditionStep;
            } else if (selectHavingConditionStep != null) {
                newSelect = selectHavingConditionStep;
            } else {
                newSelect = selectSelectStep;
            }
        }

        return newSelect;
    }

    @SuppressWarnings("unchecked")
    public static SelectConditionStep buildFromQuery(String schemaName,
                                                     SelectSelectStep selectSelectStep,
                                                     DwQuery dwQuery) {
        SelectJoinStep selectJoinStep = selectSelectStep.from(tableByName(
                schemaName, dwQuery.getTableName()));

        SelectConditionStep selectConditionStep = selectJoinStep.where();
        if (dwQuery.getWhereConditionGroup() != null) {
            selectConditionStep = ConditionHelper.buildWhereConditionGroup(schemaName, dwQuery, selectConditionStep,
                    dwQuery.getWhereConditionGroup(), false, false);
        }

        return selectConditionStep;
    }

}

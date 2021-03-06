package org.dwQueryBuilder.data;

import org.dwQueryBuilder.data.enums.CombineType;

public class DwQueryCombination {
    private CombineType combineType;
    private DwQuery dwQuery;
    private String foreignKeyFieldName;
    private String referencedFieldName;
    private String alias;

    public DwQueryCombination() {
    }

    public DwQueryCombination(CombineType combineType, DwQuery dwQuery,
                              String foreignKeyFieldName, String referencedFieldName, String alias) {
        this.combineType = combineType;
        this.dwQuery = dwQuery;
        this.foreignKeyFieldName = foreignKeyFieldName;
        this.referencedFieldName = referencedFieldName;
        this.alias = alias;
    }

    public CombineType getCombineType() {
        return combineType;
    }

    public void setCombineType(CombineType combineType) {
        this.combineType = combineType;
    }

    public DwQuery getDwQuery() {
        return dwQuery;
    }

    public void setDwQuery(DwQuery dwQuery) {
        this.dwQuery = dwQuery;
    }

    public String getForeignKeyFieldName() {
        return foreignKeyFieldName;
    }

    public void setForeignKeyFieldName(String foreignKeyFieldName) {
        this.foreignKeyFieldName = foreignKeyFieldName;
    }

    public String getReferencedFieldName() {
        return referencedFieldName;
    }

    public void setReferencedFieldName(String referencedFieldName) {
        this.referencedFieldName = referencedFieldName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}

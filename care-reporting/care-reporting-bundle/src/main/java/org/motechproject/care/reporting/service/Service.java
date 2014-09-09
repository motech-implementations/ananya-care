package org.motechproject.care.reporting.service;

import java.util.List;
import java.util.Map;

import org.motechproject.mcts.care.common.domain.SelfUpdatable;
import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;
import org.motechproject.mcts.care.common.mds.dimension.LocationDimension;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;

public interface Service {
    MotherCase getOrCreateMotherCase(String caseId);

    MotherCase getMotherCase(String caseId);

    ChildCase getOrCreateChildCase(String caseId);

    ChildCase getChildCase(String caseId);

    Flw getOrCreateFlw(String flwId);

    FlwGroup getOrCreateGroup(String groupId);

    <T> Integer save(T instance);

    <T extends SelfUpdatable<T>> void saveOrUpdateAllByExternalPrimaryKey(Class<T> clazz, List<T> instances);

    <T> T getOrCreateNew(Class<T> type, String fieldName, String value);

    <T> void update(T entity);

    <T> T get(Class<T> type, String fieldName, Object value);

    <T> T get(Class<T> type, Map<String, Object> fieldMap, Map<String, String> aliasMapping);

    void processAndSaveForms(Map<String, String> motherForm, List<Map<String,String>> childForms);

    void processAndSaveManyToManyForm(Map<String, String> formValues, List<Map<String,String>> childFormValues);

    <T extends SelfUpdatable<T>> T saveByExternalPrimaryKey(Class<T> entityClass, Map<String, String> values);

    void closeCase(String caseId, Map<String, String> updatedValues);

    LocationDimension getLocation(String state, String district, String block);

    Object execute(String query);

    <T> void saveAll(List<T> instances);
}

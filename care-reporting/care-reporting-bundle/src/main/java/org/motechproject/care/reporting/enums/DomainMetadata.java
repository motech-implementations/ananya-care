package org.motechproject.care.reporting.enums;

import static org.motechproject.care.reporting.constants.PropertyConstants.CASE;
import static org.motechproject.care.reporting.constants.PropertyConstants.CHILD;
import static org.motechproject.care.reporting.constants.PropertyConstants.FORM;
import static org.motechproject.care.reporting.constants.PropertyConstants.MOTHER;

public enum DomainMetadata {

    MOTHEREDITFORM("CARE_MCTS_COMMON_ENTITIES_MOTHEREDITFORM", FORM, MOTHER),
    MOVEBENEFICIARYFORM("CARE_MCTS_COMMON_ENTITIES_MOVEBENEFICIARYFORM", FORM, MOTHER),
    MIFORM("CARE_MCTS_COMMON_ENTITIES_MIFORM", FORM, MOTHER),
    MOFORM("CARE_MCTS_COMMON_ENTITIES_MOFORM", FORM, MOTHER),
    ABORTFORM("CARE_MCTS_COMMON_ENTITIES_ABORTFORM", FORM, MOTHER),
    UIMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_UIMOTHERFORM", FORM, MOTHER),
    REFERMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_REFERMOTHERFORM", FORM, MOTHER),
    CLOSEMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_CLOSEMOTHERFORM", FORM, MOTHER),
    DEATHMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_DEATHMOTHERFORM", FORM, MOTHER),
    DELIVERYMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_DELIVERYMOTHERFORM", FORM, MOTHER),
    CFMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_CFMOTHERFORM", FORM, MOTHER),
    EBFMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_EBFMOTHERFORM", FORM, MOTHER),
    PNCMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_PNCMOTHERFORM", FORM, MOTHER),
    BPFORM("CARE_MCTS_COMMON_ENTITIES_BPFORM", FORM, MOTHER),
    REGISTRATIONMOTHERFORM("CARE_MCTS_COMMON_ENTITIES_REGISTRATIONMOTHERFORM", FORM, MOTHER),
    NEWFORM("CARE_MCTS_COMMON_ENTITIES_NEWFORM", FORM, MOTHER),
    UICHILDFORM("CARE_MCTS_COMMON_ENTITIES_UICHILDFORM", FORM, CHILD),
    REFERCHILDFORM("CARE_MCTS_COMMON_ENTITIES_REFERCHILDFORM", FORM, CHILD),
    CLOSECHILDFORM("CARE_MCTS_COMMON_ENTITIES_CLOSECHILDFORM", FORM, CHILD),
    DEATHCHILDFORM("CARE_MCTS_COMMON_ENTITIES_DEATHCHILDFORM", FORM, CHILD),
    DELIVERYCHILDFORM("CARE_MCTS_COMMON_ENTITIES_DELIVERYCHILDFORM", FORM, CHILD),
    CFCHILDFORM("CARE_MCTS_COMMON_ENTITIES_CFCHILDFORM", FORM, CHILD),
    EBFCHILDFORM("CARE_MCTS_COMMON_ENTITIES_EBFCHILDFORM", FORM, CHILD),
    PNCCHILDFORM("CARE_MCTS_COMMON_ENTITIES_PNCCHILDFORM", FORM, CHILD),
    REGISTRATIONCHILDFORM("CARE_MCTS_COMMON_ENTITIES_REGISTRATIONCHILDFORM", FORM, CHILD),
    MOTHERCASE("CARE_MCTS_COMMON_ENTITIES_MOTHERCASE", CASE, MOTHER),
    CHILDCASE("CARE_MCTS_COMMON_ENTITIES_CHILDCASE", CASE, CHILD);

    private String tableName;
    private String type;
    private String category;

    private DomainMetadata(String tableName, String type, String category) {
        this.tableName = tableName;
        this.type = type;
        this.category = category;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
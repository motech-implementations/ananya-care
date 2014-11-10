package org.motechproject.care.reporting.enums;

import static org.motechproject.care.reporting.constants.PropertyConstants.CASE;
import static org.motechproject.care.reporting.constants.PropertyConstants.CHILD;
import static org.motechproject.care.reporting.constants.PropertyConstants.FORM;
import static org.motechproject.care.reporting.constants.PropertyConstants.MOTHER;

import org.motechproject.mcts.care.common.mds.dimension.ChildCase;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.mds.measure.AbortForm;
import org.motechproject.mcts.care.common.mds.measure.BpForm;
import org.motechproject.mcts.care.common.mds.measure.CfChildForm;
import org.motechproject.mcts.care.common.mds.measure.CfMotherForm;
import org.motechproject.mcts.care.common.mds.measure.CloseChildForm;
import org.motechproject.mcts.care.common.mds.measure.CloseMotherForm;
import org.motechproject.mcts.care.common.mds.measure.DeathChildForm;
import org.motechproject.mcts.care.common.mds.measure.DeathMotherForm;
import org.motechproject.mcts.care.common.mds.measure.DeliveryChildForm;
import org.motechproject.mcts.care.common.mds.measure.DeliveryMotherForm;
import org.motechproject.mcts.care.common.mds.measure.EbfChildForm;
import org.motechproject.mcts.care.common.mds.measure.EbfMotherForm;
import org.motechproject.mcts.care.common.mds.measure.MiForm;
import org.motechproject.mcts.care.common.mds.measure.MoForm;
import org.motechproject.mcts.care.common.mds.measure.MotherEditForm;
import org.motechproject.mcts.care.common.mds.measure.MoveBeneficiaryForm;
import org.motechproject.mcts.care.common.mds.measure.NewForm;
import org.motechproject.mcts.care.common.mds.measure.PncChildForm;
import org.motechproject.mcts.care.common.mds.measure.PncMotherForm;
import org.motechproject.mcts.care.common.mds.measure.ReferChildForm;
import org.motechproject.mcts.care.common.mds.measure.ReferMotherForm;
import org.motechproject.mcts.care.common.mds.measure.RegistrationChildForm;
import org.motechproject.mcts.care.common.mds.measure.RegistrationMotherForm;
import org.motechproject.mcts.care.common.mds.measure.UiChildForm;
import org.motechproject.mcts.care.common.mds.measure.UiMotherForm;

public enum DomainMetadata {

    MOTHEREDITFORM("CARE_MCTS_COMMON_ENTITIES_MOTHEREDITFORM", FORM, MOTHER,
            MotherEditForm.class), MOVEBENEFICIARYFORM(
            "CARE_MCTS_COMMON_ENTITIES_MOVEBENEFICIARYFORM", FORM, MOTHER,
            MoveBeneficiaryForm.class), MIFORM(
            "CARE_MCTS_COMMON_ENTITIES_MIFORM", FORM, MOTHER, MiForm.class), MOFORM(
            "CARE_MCTS_COMMON_ENTITIES_MOFORM", FORM, MOTHER, MoForm.class), ABORTFORM(
            "CARE_MCTS_COMMON_ENTITIES_ABORTFORM", FORM, MOTHER,
            AbortForm.class), UIMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_UIMOTHERFORM", FORM, MOTHER,
            UiMotherForm.class), REFERMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_REFERMOTHERFORM", FORM, MOTHER,
            ReferMotherForm.class), CLOSEMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_CLOSEMOTHERFORM", FORM, MOTHER,
            CloseMotherForm.class), DEATHMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_DEATHMOTHERFORM", FORM, MOTHER,
            DeathMotherForm.class), DELIVERYMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_DELIVERYMOTHERFORM", FORM, MOTHER,
            DeliveryMotherForm.class), CFMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_CFMOTHERFORM", FORM, MOTHER,
            CfMotherForm.class), EBFMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_EBFMOTHERFORM", FORM, MOTHER,
            EbfMotherForm.class), PNCMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_PNCMOTHERFORM", FORM, MOTHER,
            PncMotherForm.class), BPFORM("CARE_MCTS_COMMON_ENTITIES_BPFORM",
            FORM, MOTHER, BpForm.class), REGISTRATIONMOTHERFORM(
            "CARE_MCTS_COMMON_ENTITIES_REGISTRATIONMOTHERFORM", FORM, MOTHER,
            RegistrationMotherForm.class), NEWFORM(
            "CARE_MCTS_COMMON_ENTITIES_NEWFORM", FORM, MOTHER, NewForm.class), UICHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_UICHILDFORM", FORM, CHILD,
            UiChildForm.class), REFERCHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_REFERCHILDFORM", FORM, CHILD,
            ReferChildForm.class), CLOSECHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_CLOSECHILDFORM", FORM, CHILD,
            CloseChildForm.class), DEATHCHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_DEATHCHILDFORM", FORM, CHILD,
            DeathChildForm.class), DELIVERYCHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_DELIVERYCHILDFORM", FORM, CHILD,
            DeliveryChildForm.class), CFCHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_CFCHILDFORM", FORM, CHILD,
            CfChildForm.class), EBFCHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_EBFCHILDFORM", FORM, CHILD,
            EbfChildForm.class), PNCCHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_PNCCHILDFORM", FORM, CHILD,
            PncChildForm.class), REGISTRATIONCHILDFORM(
            "CARE_MCTS_COMMON_ENTITIES_REGISTRATIONCHILDFORM", FORM, CHILD,
            RegistrationChildForm.class), MOTHERCASE(
            "CARE_MCTS_COMMON_ENTITIES_MOTHERCASE", CASE, MOTHER,
            MotherCase.class), CHILDCASE("CARE_MCTS_COMMON_ENTITIES_CHILDCASE",
            CASE, CHILD, ChildCase.class);

    private String tableName;
    private String type;
    private String category;
    private Class clazz;

    private DomainMetadata(String tableName, String type, String category,
            Class clazz) {
        this.tableName = tableName;
        this.type = type;
        this.category = category;
        this.clazz = clazz;
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

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

}
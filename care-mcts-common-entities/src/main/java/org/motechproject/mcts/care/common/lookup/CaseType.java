package org.motechproject.mcts.care.common.lookup;

public enum CaseType { 
    
    Mother("cc_bihar_pregnancy"),
    Child("cc_bihar_newborn"),
    Task("task");
    
    private String caseType;

    CaseType(String case_type) {
        this.caseType=case_type;
    }

    public String getType() {
        return caseType;
    }}

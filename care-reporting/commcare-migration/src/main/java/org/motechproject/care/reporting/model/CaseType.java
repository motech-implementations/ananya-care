package org.motechproject.care.reporting.model;

public enum CaseType {
	
	Mother("mother"),Child("child");
	
	private final String caseType;
	
	private CaseType(String caseType) {
		this.caseType = caseType;
	}
	
	@Override
	public String toString() {
		return caseType;
	}

}

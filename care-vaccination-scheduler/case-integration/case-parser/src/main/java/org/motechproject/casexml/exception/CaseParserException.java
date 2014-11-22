package org.motechproject.casexml.exception;

public class CaseParserException extends Exception{
    public CaseParserException(String message) {
        super(message);
    }

    public CaseParserException(Exception ex, String message) {
        super(message, ex);
    }
}

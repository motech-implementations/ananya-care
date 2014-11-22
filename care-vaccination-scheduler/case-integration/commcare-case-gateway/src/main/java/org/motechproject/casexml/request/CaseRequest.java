package org.motechproject.casexml.request;

public class CaseRequest {
    private CreateElement createElement;
    private UpdateElement updateElement;
    private CloseElement closeElement;

    private Index index;
    private String user_id;
    private String xmlns;

    private String date_modified;

    private String case_id;

    public CaseRequest(String caseId, String userId, String dateModified) {
        this.case_id = caseId;
        this.user_id = userId;
        this.date_modified = dateModified;
        this.xmlns="http://commcarehq.org/case/transaction/v2";
    }

    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    public CaseRequest() {
        this.xmlns="http://commcarehq.org/case/transaction/v2";
    }

    public String getDate_modified() {
        return date_modified;
    }

    public String getCase_id() {
        return case_id;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }


    public CreateElement getCreateElement() {
        return createElement;
    }

    public void setCreateElement(CreateElement createElement) {
        this.createElement = createElement;
    }

    public UpdateElement getUpdateElement() {
        return updateElement;
    }

    public void setUpdateElement(UpdateElement updateElement) {
        this.updateElement = updateElement;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public void setUser_id(String userId) {
        this.user_id =  userId;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setDate_Modified(String s) {
        this.date_modified = s;
    }

    public CloseElement getCloseElement() {
        return closeElement;
    }

    public void setCloseElement(CloseElement closeElement) {
        this.closeElement = closeElement;
    }
}


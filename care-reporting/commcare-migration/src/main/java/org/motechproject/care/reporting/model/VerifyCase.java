package org.motechproject.care.reporting.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class VerifyCase implements Serializable {

    /**
     * Adding default version Serial Id.
     */
    private static final long serialVersionUID = 1L;

    private int count;

    private Date dateModifiedStart;

    private List<String> errors;

    public VerifyCase(int count, Date dateModifiedStart, List<String> errors) {
        this.count = count;
        this.dateModifiedStart = dateModifiedStart;
        this.errors = errors;
    }

    public int getCount() {
        return count;
    }

    public Date getDateModifiedStart() {
        return dateModifiedStart;
    }

    public List<String> getErrors() {
        return errors;
    }

    @Override
    public String toString() {
        return "VerifyCase " + "{ count: " + count + ", dateModifiedStart: "
                + dateModifiedStart + ", error: " + errors.toString() + "}";
    }

}

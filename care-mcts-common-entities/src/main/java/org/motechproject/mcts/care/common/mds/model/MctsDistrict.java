package org.motechproject.mcts.care.common.mds.model;

// Generated May 19, 2014 7:55:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Unique;

import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

/**
 * MctsDistrict generated by hbm2java
 */
@Entity
@Unique(members = {
        "mctsState", "disctrictId" })
public class MctsDistrict implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 4872124086594538378L;
    private MctsState mctsState;
    private int disctrictId;
    private String name;
    private boolean status;
    private Set<MctsTaluk> mctsTaluks = new HashSet<MctsTaluk>(0);

    public MctsDistrict() {
    }

    public MctsDistrict(MctsState mctsState, int disctrictId, String name) {
        this.mctsState = mctsState;
        this.disctrictId = disctrictId;
        this.name = name;
    }

    public MctsDistrict(MctsState mctsState, int disctrictId, String name,
            Set<MctsTaluk> mctsTaluks, boolean status) {
        this.mctsState = mctsState;
        this.disctrictId = disctrictId;
        this.name = name;
        this.mctsTaluks = mctsTaluks;
        this.status = status;
    }

   

    @Field(required = true)
    @Cascade(persist = true, update = true, delete = false)
    public MctsState getMctsState() {
        return this.mctsState;
    }

    public void setMctsState(MctsState mctsState) {
        this.mctsState = mctsState;
    }

    @Field(required = true)
    public int getDisctrictId() {
        return this.disctrictId;
    }

    public void setDisctrictId(int disctrictId) {
        this.disctrictId = disctrictId;
    }

    @Field(required = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Field
    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Field
    public Set<MctsTaluk> getMctsTaluks() {
        return this.mctsTaluks;
    }

    public void setMctsTaluks(Set<MctsTaluk> mctsTaluks) {
        this.mctsTaluks = mctsTaluks;
    }

}
package org.motechproject.mcts.care.common.mds.model;

// Generated May 19, 2014 7:55:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Unique;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

/**
 * MctsState generated by hbm2java
 */
@Entity
@Unique(members = "stateId")
public class MctsState implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -221246486143047967L;
    private int stateId;
    private String name;
    private boolean status;
    private Set<MctsDistrict> mctsDistricts = new HashSet<MctsDistrict>(0);

    public MctsState() {
    }

    public MctsState(int stateId, String name) {
        this.stateId = stateId;
        this.name = name;
    }

    public MctsState(int stateId, String name, Set<MctsDistrict> mctsDistricts,
            boolean status) {
        this.stateId = stateId;
        this.name = name;
        this.mctsDistricts = mctsDistricts;
        this.status = status;
    }

    @Field(required = true)
    public int getStateId() {
        return this.stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    @Field(required = true)
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
    public Set<MctsDistrict> getMctsDistricts() {
        return this.mctsDistricts;
    }

    public void setMctsDistricts(Set<MctsDistrict> mctsDistricts) {
        this.mctsDistricts = mctsDistricts;
    }

}

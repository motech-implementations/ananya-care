package org.motechproject.mcts.care.common.mds.model;

// Generated May 19, 2014 7:55:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Unique;

import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

/**
 * MctsHealthblock generated by hbm2java
 */
@Entity
@Unique(members = {
        "healthblock_id", "taluk_id" })
public class MctsHealthblock implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6873429167533803859L;
    private MctsTaluk mctsTaluk;
    private int healthblockId;
    private String name;
    private boolean status;
    private Set<MctsPhc> mctsPhcs = new HashSet<MctsPhc>(0);

    public MctsHealthblock() {
    }

    public MctsHealthblock(MctsTaluk mctsTaluk, int healthblockId, String name) {
        this.mctsTaluk = mctsTaluk;
        this.healthblockId = healthblockId;
        this.name = name;
    }

    public MctsHealthblock(MctsTaluk mctsTaluk, int healthblockId, String name,
            Set<MctsPhc> mctsPhcs, boolean status) {
        this.mctsTaluk = mctsTaluk;
        this.healthblockId = healthblockId;
        this.name = name;
        this.mctsPhcs = mctsPhcs;
        this.status = status;
    }

   
    @Field(required = true)
    @Cascade(persist = true, update = true, delete = false)
    public MctsTaluk getMctsTaluk() {
        return this.mctsTaluk;
    }

    public void setMctsTaluk(MctsTaluk mctsTaluk) {
        this.mctsTaluk = mctsTaluk;
    }

    @Field(required = true)
    public int getHealthblockId() {
        return this.healthblockId;
    }

    public void setHealthblockId(int healthblockId) {
        this.healthblockId = healthblockId;
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
    public Set<MctsPhc> getMctsPhcs() {
        return this.mctsPhcs;
    }

    public void setMctsPhcs(Set<MctsPhc> mctsPhcs) {
        this.mctsPhcs = mctsPhcs;
    }

}
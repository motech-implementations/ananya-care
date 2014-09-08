package org.motechproject.mcts.care.common.mds.model;

// Generated May 19, 2014 7:55:47 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Unique;

import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

/**
 * MctsTaluk generated by hbm2java
 */
@Entity
@Unique(members = {
        "talukId", "mctsDistrict" })
public class MctsTaluk implements java.io.Serializable {

    
    private static final long serialVersionUID = -226240310604906915L;
    private MctsDistrict mctsDistrict;
    private int talukId;
    private String name;
    private boolean status;
    private Set<MctsHealthblock> mctsHealthblocks = new HashSet<MctsHealthblock>(
            0);
    private Set<MctsVillage> mctsVillages = new HashSet<MctsVillage>(0);

    public MctsTaluk() {
    }

    public MctsTaluk(MctsDistrict mctsDistrict, int talukId, String name) {
        this.mctsDistrict = mctsDistrict;
        this.talukId = talukId;
        this.name = name;
    }

    public MctsTaluk(MctsDistrict mctsDistrict, int talukId, String name,
            Set<MctsHealthblock> mctsHealthblocks,
            Set<MctsVillage> mctsVillages, boolean status) {
        this.mctsDistrict = mctsDistrict;
        this.talukId = talukId;
        this.name = name;
        this.mctsHealthblocks = mctsHealthblocks;
        this.mctsVillages = mctsVillages;
        this.status = status;
    }

    @Field(required = true)
    @Cascade(persist = true, update = true, delete = false)
    public MctsDistrict getMctsDistrict() {
        return this.mctsDistrict;
    }

    public void setMctsDistrict(MctsDistrict mctsDistrict) {
        this.mctsDistrict = mctsDistrict;
    }

    @Field(required = true)
    public int getTalukId() {
        return this.talukId;
    }

    public void setTalukId(int talukId) {
        this.talukId = talukId;
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
    public Set<MctsHealthblock> getMctsHealthblocks() {
        return this.mctsHealthblocks;
    }

    public void setMctsHealthblocks(Set<MctsHealthblock> mctsHealthblocks) {
        this.mctsHealthblocks = mctsHealthblocks;
    }

    @Field
    public Set<MctsVillage> getMctsVillages() {
        return this.mctsVillages;
    }

    public void setMctsVillages(Set<MctsVillage> mctsVillages) {
        this.mctsVillages = mctsVillages;
    }

}
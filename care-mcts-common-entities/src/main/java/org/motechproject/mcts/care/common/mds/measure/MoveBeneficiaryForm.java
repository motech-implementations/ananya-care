package org.motechproject.mcts.care.common.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mcts.care.common.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "move_beneficiary_form")
@Unique(members = "instanceId")
public class MoveBeneficiaryForm extends Form {

    private Flw flw;
    private MotherCase motherCase;
    private DateTime timeEnd;
    private DateTime timeStart;
    private DateTime dateModified;
    private DateTime creationTime = new DateTime();
    private String confirmMove;
    private Integer newWard;
    private Integer newAwcc;
    private String confirmAgain;

    public MoveBeneficiaryForm() {
    }

    @Field
    @Cascade(persist = true, update = true, delete = false)
    public Flw getFlw() {
        return this.flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

    
    @Field
    @Cascade(persist = true, update = true, delete = false)
    public MotherCase getMotherCase() {
        return this.motherCase;
    }

    public void setMotherCase(MotherCase motherCase) {
        this.motherCase = motherCase;
    }

    
    @Field
    public DateTime getTimeEnd() {
        return this.timeEnd;
    }

    public void setTimeEnd(DateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    
    @Field
    public DateTime getTimeStart() {
        return this.timeStart;
    }

    public void setTimeStart(DateTime timeStart) {
        this.timeStart = timeStart;
    }

    
    @Field
    public DateTime getDateModified() {
        return this.dateModified;
    }

    public void setDateModified(DateTime dateModified) {
        this.dateModified = dateModified;
    }

    
    @Field
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Field
    public String getConfirmMove() {
        return confirmMove;
    }

    public void setConfirmMove(String confirmMove) {
        this.confirmMove = confirmMove;
    }

    @Field
    public Integer getNewWard() {
        return newWard;
    }

    public void setNewWard(Integer newWard) {
        this.newWard = newWard;
    }

    @Field
    public Integer getNewAwcc() {
        return newAwcc;
    }

    public void setNewAwcc(Integer newAwcc) {
        this.newAwcc = newAwcc;
    }

    @Field
    public String getConfirmAgain() {
        return confirmAgain;
    }

    public void setConfirmAgain(String confirmAgain) {
        this.confirmAgain = confirmAgain;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }
}

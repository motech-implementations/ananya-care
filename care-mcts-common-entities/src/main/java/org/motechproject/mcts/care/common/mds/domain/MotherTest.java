package org.motechproject.mcts.care.common.mds.domain;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.joda.time.DateTime;
import org.motechproject.commons.date.util.DateUtil;
import org.motechproject.mcts.care.common.lookup.CaseType;
import org.motechproject.mcts.care.common.utils.NullAwareBeanUtilsBean;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "MotherTest")
public class MotherTest extends ClientTest {

    private static final long serialVersionUID = 7542211703701595440L;
    
    @Field
    private DateTime edd;
    @Field
    private DateTime add;
    @Field
    private DateTime tt1Date;
    @Field
    private DateTime tt2Date;
    @Field
    private Boolean lastPregTt;
    @Field
    private DateTime anc1Date;
    @Field
    private DateTime anc2Date;
    @Field
    private DateTime anc3Date;
    @Field
    private DateTime anc4Date;
    @Field
    private DateTime ttBoosterDate;
    @Field
    private String caseType;

    public MotherTest(String caseId, DateTime dateModified, String flwId, String name, String groupId, DateTime edd, DateTime add, DateTime tt1Date, DateTime tt2Date, boolean lastPregTt, DateTime anc1Date, DateTime anc2Date, DateTime anc3Date, DateTime anc4Date, DateTime ttBoosterDate, boolean isAlive) {
        super(isAlive);
        this.caseId = caseId;
        this.dateModified = dateModified;
        this.flwId = flwId;
        this.name = name;
        this.groupId = groupId;
        this.edd = edd;
        this.add = add;
        this.tt1Date = tt1Date;
        this.tt2Date = tt2Date;
        this.lastPregTt = lastPregTt;
        this.anc1Date = anc1Date;
        this.anc2Date = anc2Date;
        this.anc3Date = anc3Date;
        this.anc4Date = anc4Date;
        this.ttBoosterDate = ttBoosterDate;
        this.caseType = CaseType.MOTHER;
    }

    public MotherTest() {
        this.caseType=CaseType.MOTHER;
    }

    public DateTime getTt1Date() {
        return DateUtil.setTimeZone(tt1Date);
    }

    public void setTt1Date(DateTime tt1Date) {
        this.tt1Date = tt1Date;
    }

    public DateTime getTt2Date() {
        return DateUtil.setTimeZone(tt2Date);
    }

    public void setTt2Date(DateTime tt2Date) {
        this.tt2Date = tt2Date;
    }

    public boolean isLastPregTt() {
        return lastPregTt;
    }

    public void setLastPregTt(boolean lastPregTt) {
        this.lastPregTt = lastPregTt;
    }

    public DateTime getAnc1Date() {
        return DateUtil.setTimeZone(anc1Date);
    }

    public void setAnc1Date(DateTime anc1Date) {
        this.anc1Date = anc1Date;
    }

    public DateTime getAnc2Date() {
        return DateUtil.setTimeZone(anc2Date);
    }

    public void setAnc2Date(DateTime anc2Date) {
        this.anc2Date = anc2Date;
    }

    public DateTime getAnc3Date() {
        return DateUtil.setTimeZone(anc3Date);
    }

    public void setAnc3Date(DateTime anc3Date) {
        this.anc3Date = anc3Date;
    }

    public DateTime getAnc4Date() {
        return DateUtil.setTimeZone(anc4Date);
    }

    public void setAnc4Date(DateTime anc4Date) {
        this.anc4Date = anc4Date;
    }

    public DateTime getTtBoosterDate() {
        return DateUtil.setTimeZone(ttBoosterDate);
    }

    public void setTtBoosterDate(DateTime ttBoosterDate) {
        this.ttBoosterDate = ttBoosterDate;
    }

    public DateTime getEdd() {
        return DateUtil.setTimeZone(edd);
    }

    public void setEdd(DateTime edd) {
        this.edd = edd;
    }

    public DateTime getAdd() {
        return DateUtil.setTimeZone(add);
    }

    public void setAdd(DateTime add) {
        this.add = add;
    }

    /*public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType=caseType;
    }
*/
    public void setValuesFrom(MotherTest mother) {
        try{
            NullAwareBeanUtilsBean nullAwareBeanUtilsBean = new NullAwareBeanUtilsBean();
            nullAwareBeanUtilsBean.copyProperties(this, mother);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    @JsonIgnore
    public boolean isActive() {
        return super.isActive() && add == null;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = CaseType.MOTHER;
        
    }

}
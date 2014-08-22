package org.motechproject.care.reporting.mds.measure;

import javax.jdo.annotations.Unique;

import org.joda.time.DateTime;
import org.motechproject.care.reporting.mds.dimension.Flw;
import org.motechproject.care.reporting.mds.dimension.MotherCase;
import org.motechproject.care.reporting.utils.FormToString;
import org.motechproject.mds.annotations.Cascade;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;


@Entity(name = "mi_form")
@Unique(members = "instance_id")
public class MiForm extends Form {

	 private Flw flw;
	private MotherCase motherCase;
	private DateTime timeEnd;
	private DateTime timeStart;
	private DateTime dateModified;
	private DateTime dateArrived;
	private DateTime dateLearned;
	private DateTime dateOfDelivery;
	private String name;
	private String pregStatus;
	private String referralInfo;
	private String abortionType;
	private DateTime dateAborted;
	private String migratedStatus;
    private String status;
    private DateTime creationTime = new DateTime();
    private DateTime dateDelFu;

    public MiForm() {
	}

	@Field(name = "user_id")
    @Cascade(persist = true, update = true, delete = false)
	public Flw getFlw() {
		return this.flw;
	}

	public void setFlw(Flw flw) {
		this.flw = flw;
	}

	
	@Field(name = "case_id")
    @Cascade(persist = true, update = true, delete = false)
	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
	}

	
	@Field(name = "time_end")
	public DateTime getTimeEnd() {
		return this.timeEnd;
	}

	public void setTimeEnd(DateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	
	@Field(name = "time_start")
	public DateTime getTimeStart() {
		return this.timeStart;
	}

	public void setTimeStart(DateTime timeStart) {
		this.timeStart = timeStart;
	}

	
	@Field(name = "date_modified")
	public DateTime getDateModified() {
		return this.dateModified;
	}

	public void setDateModified(DateTime dateModified) {
		this.dateModified = dateModified;
	}

	
	@Field(name = "date_arrived")
	public DateTime getDateArrived() {
		return this.dateArrived;
	}

	public void setDateArrived(DateTime dateArrived) {
		this.dateArrived = dateArrived;
	}

	
	@Field(name = "date_learned")
	public DateTime getDateLearned() {
		return this.dateLearned;
	}

	public void setDateLearned(DateTime dateLearned) {
		this.dateLearned = dateLearned;
	}

	
	@Field(name = "date_of_delivery")
	public DateTime getDateOfDelivery() {
		return this.dateOfDelivery;
	}

	public void setDateOfDelivery(DateTime dateOfDelivery) {
		this.dateOfDelivery = dateOfDelivery;
	}

	@Field(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Field(name = "preg_status")
	public String getPregStatus() {
		return this.pregStatus;
	}

	public void setPregStatus(String pregStatus) {
		this.pregStatus = pregStatus;
	}

	@Field(name = "referral_info")
	public String getReferralInfo() {
		return this.referralInfo;
	}

	public void setReferralInfo(String referralInfo) {
		this.referralInfo = referralInfo;
	}

	@Field(name = "abortion_type")
	public String getAbortionType() {
		return this.abortionType;
	}

	public void setAbortionType(String abortionType) {
		this.abortionType = abortionType;
	}

	
	@Field(name = "date_aborted")
	public DateTime getDateAborted() {
		return this.dateAborted;
	}

	public void setDateAborted(DateTime dateAborted) {
		this.dateAborted = dateAborted;
	}

	@Field(name = "migrated_status")
	public String getMigratedStatus() {
		return this.migratedStatus;
	}

	public void setMigratedStatus(String migratedStatus) {
		this.migratedStatus = migratedStatus;
	}


    @Field(name = "status")
    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    @Field(name = "creation_time")
    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return FormToString.toString(this);
    }

    @Field(name = "date_del_fu")
    public DateTime getDateDelFu() {
        return dateDelFu;
    }

    public void setDateDelFu(DateTime dateDelFu) {
        this.dateDelFu = dateDelFu;
    }
}

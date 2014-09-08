package org.motechproject.mcts.care.common.mds.model;

// Generated May 26, 2014 2:25:24 PM by Hibernate Tools 3.4.0.CR1

import org.motechproject.mcts.care.common.lookup.MCTSPregnantMotherCaseAuthorisedStatus;
import org.motechproject.mcts.care.common.mds.dimension.MotherCase;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

/**
 * MctsPregnantMother generated by hbm2java
 */
@Entity
public class MotherCaseMctsUpdate implements java.io.Serializable {

	/**
	 * case_id, , 2 columns full_mcts_id, mcts_id, authorized 
	 */
	private static final long serialVersionUID = -8318971109619756076L;
	private MotherCase motherCase;
	private String mctsId;
	private MCTSPregnantMotherCaseAuthorisedStatus mCTSPregnantMotherCaseAuthorisedStatus;	
	private String fullMctsId;
	private String dateModified;

	@Field
	public String getFullMctsId() {
		return fullMctsId;
	}

	public void setFullMctsId(String fullMctsId) {
		this.fullMctsId = fullMctsId;
	}

	public MotherCaseMctsUpdate() {
	}

	public MotherCaseMctsUpdate(Integer id, MotherCase motherCase,
			 String mctsId, String fullMctsId,
			 MCTSPregnantMotherCaseAuthorisedStatus mCTSPregnantMotherCaseAuthorisedStatus) {
		super();
		this.motherCase = motherCase;
		this.mctsId = mctsId;
		this.fullMctsId = fullMctsId;
		this.mCTSPregnantMotherCaseAuthorisedStatus = mCTSPregnantMotherCaseAuthorisedStatus;
	}


	@Field
	public MotherCase getMotherCase() {
		return this.motherCase;
	}

	public void setMotherCase(MotherCase motherCase) {
		this.motherCase = motherCase;
	}
	
	
	@Field
	public MCTSPregnantMotherCaseAuthorisedStatus getmCTSPregnantMotherCaseAuthorisedStatus() {
        return mCTSPregnantMotherCaseAuthorisedStatus;
    }

    public void setmCTSPregnantMotherCaseAuthorisedStatus(
            MCTSPregnantMotherCaseAuthorisedStatus mCTSPregnantMotherCaseAuthorisedStatus) {
        this.mCTSPregnantMotherCaseAuthorisedStatus = mCTSPregnantMotherCaseAuthorisedStatus;
    }

    @Field
	public String getMctsId() {
		return this.mctsId;
	}

	public void setMctsId(String mctsId) {
		this.mctsId = mctsId;
	}
	
	@Field
	public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }

}
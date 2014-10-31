package org.motechproject.mcts.care.common.mds.measure;

import org.joda.time.DateTime;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity(name = "job_metadata")
public class JobMetadata implements java.io.Serializable {

    private static final long serialVersionUID = 4582428269503462660L;

    @Field
    private String jobName;

    @Field
    private DateTime lastRun;

    public JobMetadata(String jobName, DateTime lastRun) {
        this.jobName = jobName;
        this.lastRun = lastRun;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public DateTime getLastRun() {
        return lastRun;
    }

    public void setLastRun(DateTime lastRun) {
        this.lastRun = lastRun;
    }
}
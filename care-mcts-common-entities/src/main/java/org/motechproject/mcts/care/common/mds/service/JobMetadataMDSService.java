package org.motechproject.mcts.care.common.mds.service;

import org.motechproject.mcts.care.common.mds.measure.JobMetadata;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface JobMetadataMDSService extends MotechDataService<JobMetadata> {

    @Lookup(name = "By JobName")
    JobMetadata findByJobName(
            @LookupField(name = "jobName") String jobName);

}

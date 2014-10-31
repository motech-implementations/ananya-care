package org.motechproject.mcts.care.common.mds.service;

import java.util.List;

import org.motechproject.mcts.care.common.mds.measure.DomainMetadata;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface DomainMetadataMDSService extends
        MotechDataService<DomainMetadata> {

    @Lookup(name = "By Type and Category")
    List<DomainMetadata> findByTypeAndCategory(
            @LookupField(name = "type") String type, @LookupField(
                    name = "category") String category);
}

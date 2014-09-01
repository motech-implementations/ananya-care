package org.motechproject.care.reporting.builder;

import java.util.Date;
import java.util.HashSet;

import org.joda.time.DateTime;
import org.motechproject.mcts.care.common.mds.dimension.Flw;
import org.motechproject.mcts.care.common.mds.dimension.FlwGroup;

public class FlwBuilder {
    Flw flw;

    public FlwBuilder() {
        flw = new Flw();
    }

    public FlwBuilder flwId(String flwId) {
        flw.setFlwId(flwId);
        return this;
    }

    public FlwBuilder firstName(String firstName) {
        flw.setFirstName(firstName);
        return this;
    }

    public Flw build() {
        return flw;
    }

     public FlwBuilder creationTime(DateTime creationTime) {
        flw.setCreationTime(creationTime);
        return this;
    }
   //TODO: uncomment below
     /*
    public FlwBuilder flwGroups(HashSet<FlwGroup> flwGroups) {
        flw.setFlwGroups(flwGroups);
        return this;
    }

    public static Flw buildDefault() {
        return new FlwBuilder()
                .flwId("5ba9a0928dde95d187544babf6c0ad24")
                .firstName("FirstName1")
                .flwGroups(FlwGroupBuilder.buildDefaultSet())
                .build();
    }*/
}

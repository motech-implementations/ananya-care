package org.motechproject.mcts.care.common.mds.dimension;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
@Entity
public class FlwGroupMap implements java.io.Serializable {

    private static final long serialVersionUID = 1325270026216609695L;
    
    @Field
    private Flw flw;

    public Flw getFlw() {
        return flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

    public FlwGroup getFlwGroup() {
        return flwGroup;
    }

    public void setFlwGroup(FlwGroup flwGroup) {
        this.flwGroup = flwGroup;
    }

    @Field
    FlwGroup flwGroup;

}

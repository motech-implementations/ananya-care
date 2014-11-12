package org.motechproject.mcts.care.common.mds.dimension;

import javax.jdo.annotations.Unique;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
@Entity(name="flw_group_map")
@Unique(members = { "flw", "flwGroup" })
public class FlwGroupMap implements java.io.Serializable {

    private static final long serialVersionUID = 1325270026216609695L;
    
    private Flw flw;
    
    private FlwGroup flwGroup;

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

    

}

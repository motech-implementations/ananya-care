package org.motechproject.mcts.care.common.mds.dimension;

import java.util.List;

public class FlwAndFlwGroupMapList {

    private Flw flw;
    private List<FlwGroupMap> flwGroupMapList;

    public FlwAndFlwGroupMapList(Flw flw, List<FlwGroupMap> flwGroupMapList) {
        this.flw = flw;
        this.flwGroupMapList = flwGroupMapList;
    }

    public Flw getFlw() {
        return flw;
    }

    public void setFlw(Flw flw) {
        this.flw = flw;
    }

    public List<FlwGroupMap> getFlwGroupMapList() {
        return flwGroupMapList;
    }

    public void setFlwGroupMapList(List<FlwGroupMap> flwGroupMapList) {
        this.flwGroupMapList = flwGroupMapList;
    }
}

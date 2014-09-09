package org.motechproject.mcts.care.common.mds.domain;

import org.joda.time.DateTime;
import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

@Entity
public class Window implements java.io.Serializable {

    private static final long serialVersionUID = 7444463723641717920L;

    private DateTime start;
    private DateTime end;

    public Window(DateTime start, DateTime end) {
        this.start = start;
        this.end = end;
    }

    public Window resize(Window limit) {
        DateTime start = this.start.isBefore(limit.start) ? limit.start
                : this.start;
        DateTime end = this.end.isAfter(limit.end) ? limit.end : this.end;
        return new Window(start, end);
    }

    public boolean isValid() {
        return !start.isAfter(end);
    }

    @Field
    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    @Field
    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }
}

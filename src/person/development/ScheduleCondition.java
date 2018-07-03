package person.development;

import java.util.Date;

public interface ScheduleCondition {

    public void add(ScheduleCondition condition);

    public void remove(ScheduleCondition condition);

    boolean contains(ScheduleCondition condition);

    boolean fitsDate(Date date);
}

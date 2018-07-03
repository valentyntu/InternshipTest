package person.development;

import java.time.LocalDate;

public interface ScheduleCondition {

    public void add(ScheduleCondition condition);

    public void remove(ScheduleCondition condition);

    boolean contains(ScheduleCondition condition);

    boolean fitsDate(LocalDate date);
}

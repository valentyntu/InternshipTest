package person.development;

import java.time.Period;

public class Schedule {
    private Period period;

    private ScheduleCondition scheduleCondition;

    public Schedule(Period period, ScheduleCondition scheduleCondition) {
        this.period = period;
        this.scheduleCondition = scheduleCondition;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public ScheduleCondition getScheduleCondition() {
        return scheduleCondition;
    }

    public void setScheduleCondition(ScheduleCondition scheduleCondition) {
        this.scheduleCondition = scheduleCondition;
    }
}

package person.development;

public enum SimpleCondition implements ScheduleCondition {
    ONCE, DAILY, WEEKLY, MONTHLY, ON_WEEKDAY;

    @Override
    public void add(ScheduleCondition condition) {
        //Should not be used
    }

    @Override
    public void remove(ScheduleCondition condition) {
        //Should not be used
    }
}

package person.development;

import java.time.LocalDate;

public enum DayOFWeekCondition implements ScheduleCondition {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    @Override
    public void add(ScheduleCondition condition) {
        //Should not be used
    }

    @Override
    public void remove(ScheduleCondition condition) {
        //Should not be used
    }

    @Override
    public boolean contains(ScheduleCondition condition) {
        return this.equals(condition);
    }

    @Override
    public boolean fitsDate(LocalDate date) {
        return date.getDayOfWeek().ordinal() == this.ordinal();
    }
}

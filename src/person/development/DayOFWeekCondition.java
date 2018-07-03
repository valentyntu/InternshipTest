package person.development;

import java.time.LocalDate;

public enum DayOFWeekCondition implements ScheduleCondition {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);

    private int code;

    DayOFWeekCondition(int code) {
        this.code = code;
    }

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

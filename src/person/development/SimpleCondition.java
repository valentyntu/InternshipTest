package person.development;

import java.time.DayOfWeek;
import java.time.LocalDate;

public enum SimpleCondition implements ScheduleCondition {
    ONCE, DAILY, WEEKLY, MONTHLY, ON_WORKING_DAY, ON_WEEKEND;

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
        return condition.equals(this);
    }

    @Override
    public boolean fitsDate(LocalDate date) {
        switch (this) {
            case ONCE: {
                return true;
            }
            case DAILY: {
                return true;
            }
            case WEEKLY: {
                return true;
            }
            case MONTHLY: {
                return true;
            }
            case ON_WORKING_DAY: {
                return isAWorkingDay(date);
            }
            case ON_WEEKEND: {
                return isAWeekend(date);
            }
            default:
                return false;
        }
    }

    public static boolean isAWeekend(LocalDate date) {
        return (date.getDayOfWeek() == DayOfWeek.SUNDAY) || (date.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public static boolean isAWorkingDay(LocalDate date) {
        return !isAWeekend(date);
    }

}

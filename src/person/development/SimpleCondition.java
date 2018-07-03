package person.development;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

public enum SimpleCondition implements ScheduleCondition {
    ONCE, DAILY, WEEKLY, MONTHLY, ON_WORKING_DAY, ON_WEEKEND, NOT_IN_SUMMER;

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
            case NOT_IN_SUMMER: {
                return !isSummer(date);
            }
            default:
                return false;
        }
    }

    private boolean isSummer(LocalDate date) {
        return date.getMonth() == Month.JUNE || date.getMonth() == Month.JULY || date.getMonth() == Month.AUGUST;
    }

    public static boolean isAWeekend(LocalDate date) {
        return (date.getDayOfWeek() == DayOfWeek.SUNDAY) || (date.getDayOfWeek() == DayOfWeek.SATURDAY);
    }

    public static boolean isAWorkingDay(LocalDate date) {
        return !isAWeekend(date);
    }

}

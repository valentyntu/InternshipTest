package person.development;

import java.util.Calendar;
import java.util.Date;

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
    public boolean fitsDate(Date date) {
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

    public static boolean isAWeekend(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.SUNDAY) || (dayOfWeek == Calendar.SATURDAY);
    }

    public static boolean isAWorkingDay(Date date) {
        return !isAWeekend(date);
    }

}

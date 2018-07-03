package person.development;

import java.util.Calendar;
import java.util.Date;

public enum DayOFWeekCondition implements ScheduleCondition {
    MONDAY(2), TUESDAY(3), WEDNESDAY(4), THURSDAY(5), FRIDAY(6), SATURDAY(7), SUNDAY(1);

    private int order;

    DayOFWeekCondition(int order) {
        this.order = order;
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
    public boolean fitsDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return (order == calendar.get(Calendar.DAY_OF_WEEK));
    }
}

package person.development;

import person.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private Date dateStart;
    private Date dateEnd;
    private ScheduleCondition scheduleCondition;
    private Map<Student, Date> datesOfLastFinishing;

    public Schedule(Date dateStart, Date dateEnd, ScheduleCondition scheduleCondition) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.scheduleCondition = scheduleCondition;
        datesOfLastFinishing = new HashMap<>();
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public ScheduleCondition getScheduleCondition() {
        return scheduleCondition;
    }

    public void setScheduleCondition(ScheduleCondition scheduleCondition) {
        this.scheduleCondition = scheduleCondition;
    }

    public boolean isWorkingToday(Date today, Student student) {
        if (today.after(dateEnd) || today.before(dateStart)) {
            return false;
        } else {
            if (scheduleCondition.contains(SimpleCondition.WEEKLY)) {
                if (startedNewWeek(datesOfLastFinishing.get(student), today) && scheduleCondition.fitsDate(today)) {
                    datesOfLastFinishing.put(student, today);
                    return true;
                } else {
                    return false;
                }
            }

            if (scheduleCondition.contains(SimpleCondition.MONTHLY)) {
                if (startedNewMonth(datesOfLastFinishing.get(student), today) && scheduleCondition.fitsDate(today)) {
                    datesOfLastFinishing.put(student, today);
                    return true;
                } else {
                    return false;
                }
            }

            if (scheduleCondition.fitsDate(today)) {
                datesOfLastFinishing.put(student, today);
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean startedNewWeek(Date from, Date now) {
        if (from == null) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        int weekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(now);
        int currentWeekOfYear = calendar.get(Calendar.WEEK_OF_YEAR);
        return currentWeekOfYear > weekOfYear;
    }

    private boolean startedNewMonth(Date from, Date now) {
        if (from == null) {
            return true;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(from);
        int month = calendar.get(Calendar.MONTH);
        calendar.setTime(now);
        int currentMonth = calendar.get(Calendar.MONTH);
        return currentMonth > month;
    }
}

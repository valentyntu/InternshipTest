package person.development;

import person.Student;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Schedule {
    private LocalDate dateStart;
    private LocalDate dateEnd;
    private ScheduleCondition scheduleCondition;
    private Map<Student, LocalDate> datesOfLastFinishing;

    public Schedule(LocalDate dateStart, LocalDate dateEnd, ScheduleCondition scheduleCondition) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.scheduleCondition = scheduleCondition;
        datesOfLastFinishing = new HashMap<>();
    }

    public ScheduleCondition getScheduleCondition() {
        return scheduleCondition;
    }

    public void setScheduleCondition(ScheduleCondition scheduleCondition) {
        this.scheduleCondition = scheduleCondition;
    }

    public boolean isWorkingToday(LocalDate today, Student student) {
        if (today.isAfter(dateEnd) || today.isBefore(dateStart)) {
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

    private boolean startedNewWeek(LocalDate from, LocalDate now) {
        if (from == null) {
            return true;
        }
        int daysInYear = from.isLeapYear() ? 366 : 365;
        int weekOfYear = daysInYear / from.getDayOfYear();
        int currentWeekOfYear = daysInYear / now.getDayOfYear();
        return currentWeekOfYear > weekOfYear || now.getYear() > from.getYear();
    }

    private boolean startedNewMonth(LocalDate from, LocalDate now) {
        if (from == null) {
            return true;
        }
        return now.getMonth().ordinal() > from.getMonth().ordinal() || now.getYear() > from.getYear();
    }
}

package person.development;

import person.Student;

import java.time.LocalDate;
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

    public boolean isApplicableOn(LocalDate today, Student student) {
        if (!isInPeriod(today) || wasAttendedBy(student, today)) {
            return false;
        } else {
            if (scheduleCondition.fitsDate(today)) {

                if (scheduleCondition.contains(SimpleCondition.WEEKLY)
                        && startedNewWeek(datesOfLastFinishing.get(student), today)) {
                    return registerMeasureAttendance(today, student);
                }

                if (scheduleCondition.contains(SimpleCondition.MONTHLY)
                        && startedNewMonth(datesOfLastFinishing.get(student), today)) {
                    return registerMeasureAttendance(today, student);
                }

                if (scheduleCondition.contains(SimpleCondition.ONCE)) {
                    if (datesOfLastFinishing.get(student) == null) {
                        return registerMeasureAttendance(today, student);
                    } else {
                        return false;
                    }
                }

                return registerMeasureAttendance(today, student);

            } else {
                return false;
            }
        }
    }

    private boolean registerMeasureAttendance(LocalDate today, Student student) {
        datesOfLastFinishing.put(student, today);
        return true;
    }

    private boolean wasAttendedBy(Student student, LocalDate today) {
        return datesOfLastFinishing.get(student) != null && datesOfLastFinishing.get(student).isEqual(today);
    }

    private boolean isInPeriod(LocalDate today) {
        return today.isBefore(dateEnd) || today.isAfter(dateStart);
    }

    private boolean startedNewWeek(LocalDate from, LocalDate now) {
        if (from == null) {
            return true;
        }
        int DAYS_IN_WEEK = 7;
        return now.getDayOfYear() - from.getDayOfYear() >= DAYS_IN_WEEK || now.getYear() > from.getYear();
    }

    private boolean startedNewMonth(LocalDate from, LocalDate now) {
        if (from == null) {
            return true;
        }
        return now.getMonth().ordinal() > from.getMonth().ordinal() || now.getYear() > from.getYear();
    }
}

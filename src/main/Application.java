package main;

import institution.University;
import institution.interlink.Internship;
import person.HardcodedStudentRepository;
import person.Student;
import person.StudentRepository;
import person.development.ComplexCondition;
import person.development.DayOFWeekCondition;
import person.development.DevelopmentMeasure;
import person.development.DevelopmentPlan;
import person.development.Schedule;
import person.development.SimpleCondition;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class Application {

    private static StudentRepository studentRepository;

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    public static Date parseDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat(DATE_FORMAT);
        return format.parse(date);
    }

    public static void main(String[] args) throws ParseException {
        studentRepository = new HardcodedStudentRepository();

        University university = createUniversity();

        Internship internship = createInternship(university);
        internship.printStudents();

        List<Student> studentRegistry = studentRepository.getStudents();
        LocalDate workingDate = LocalDate.of(2018, 7, 3);
        studentRegistry.forEach(student -> student.workOnDevelopmentPlan(workingDate));
        studentRegistry.forEach(student -> student.workOnDevelopmentPlan(workingDate));
    }

    private static University createUniversity() throws ParseException {
        University university = new University("CH.U.I.");
        university.setStudents(studentRepository.getStudents());
        DevelopmentPlan universityDevelopmentPlan = new DevelopmentPlan();
        LocalDate universityDateStart = LocalDate.of(2018, 1, 1);
        LocalDate universityDateEnd = LocalDate.of(2021, 6, 30);
        Schedule studyingSchedule = new Schedule(universityDateStart, universityDateEnd, SimpleCondition.ON_WORKING_DAY);
        DevelopmentMeasure studying = new DevelopmentMeasure(studyingSchedule, university);
        universityDevelopmentPlan.addMeasure(studying);
        university.setDevelopmentPlan(universityDevelopmentPlan);
        return university;
    }

    private static Internship createInternship(University university) throws ParseException {
        Internship internship = new Internship("Interlink", university);
        DevelopmentPlan internshipPlan = new DevelopmentPlan();
        LocalDate internshipDateStart = LocalDate.of(2018, 7, 2);
        LocalDate internshipDateEnd = LocalDate.of(2018, 9, 30);
        ComplexCondition internshipCondition = new ComplexCondition();
        internshipCondition.add(SimpleCondition.WEEKLY);
        internshipCondition.add(DayOFWeekCondition.TUESDAY);
        Schedule internshipStudyingSchedule = new Schedule(internshipDateStart, internshipDateEnd, internshipCondition);
        DevelopmentMeasure internshipStudying = new DevelopmentMeasure(internshipStudyingSchedule, internship);
        internshipPlan.addMeasure(internshipStudying);
        internship.setDevelopmentPlan(internshipPlan);
        return internship;
    }
}

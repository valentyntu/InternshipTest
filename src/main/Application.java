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

import java.time.LocalDate;
import java.util.List;

public class Application {

    private static StudentRepository studentRepository = new HardcodedStudentRepository();

    public static void main(String[] args) {
        University university = createUniversity();

        Internship internship = createInternship(university);
        internship.printStudents();

        makeStudentsWork();
    }

    private static void makeStudentsWork() {
        List<Student> studentRegistry = studentRepository.getStudents();
        LocalDate workingDate = LocalDate.of(2018, 7, 3);
        for (int i = 0; i < 2; i++) {
            studentRegistry.forEach(student -> student.workOnDevelopmentPlan(workingDate));
            System.out.println();
        }
    }

    private static University createUniversity() {
        University university = new University("CH.U.I.");
        university.setStudentsList(studentRepository.getStudents());
        LocalDate universityDateStart = LocalDate.of(2018, 1, 1);
        LocalDate universityDateEnd = LocalDate.of(2021, 6, 30);
        ComplexCondition condition = new ComplexCondition();
        condition.add(SimpleCondition.ON_WORKING_DAY);
        condition.add(SimpleCondition.NOT_IN_SUMMER);
        Schedule studyingSchedule = new Schedule(universityDateStart, universityDateEnd, condition);
        DevelopmentMeasure studying = new DevelopmentMeasure(studyingSchedule, university);
        university.addDevelopmentMeasureToPlan(studying);
        return university;
    }

    private static Internship createInternship(University university) {
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

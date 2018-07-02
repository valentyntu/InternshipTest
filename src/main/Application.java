package main;

import institution.University;
import institution.interlink.Internship;
import person.HardcodedStudentRepository;
import person.StudentRepository;
import person.development.DevelopmentMeasure;
import person.development.DevelopmentPlan;
import person.development.Schedule;
import person.development.SimpleCondition;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Application {

    private static StudentRepository studentRepository;

    public static void main(String[] args) {
        studentRepository = new HardcodedStudentRepository();

        University university = new University("CH.U.I.");
        university.setStudents(studentRepository.getStudents());

        DevelopmentPlan universityDevelopmentPlan = new DevelopmentPlan();

        LocalDate timeStart = LocalDate.parse("2018-09-01", DateTimeFormatter.ISO_DATE);
        LocalDate timeEnd = LocalDate.parse("2021-06-30", DateTimeFormatter.ISO_DATE);
        Period studyingPeriod = Period.between(timeStart, timeEnd);

        Schedule studyingSchedule = new Schedule(studyingPeriod, SimpleCondition.ON_WEEKDAY);
        DevelopmentMeasure studying = new DevelopmentMeasure(studyingSchedule, university);
        universityDevelopmentPlan.addMeasure(studying);
        university.setDevelopmentPlan(universityDevelopmentPlan);


        Internship internship = new Internship("Interlink", university);
        internship.printStudents();
    }
}

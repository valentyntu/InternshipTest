package main;

import institution.University;
import institution.interlink.Internship;
import person.HardcodedStudentRepository;
import person.StudentRepository;

public class Application {

    private static StudentRepository studentRepository;

    public static void main(String[] args) {
        studentRepository = new HardcodedStudentRepository();

        University university = new University("CH.U.I.");
        university.setStudents(studentRepository.getStudents());

        Internship internship = new Internship("Interlink", university.getStudentsList());
        internship.printStudents();
    }
}

package main;

import institution.University;
import institution.interlink.Internship;
import person.Student;
import person.consciousness.KnowledgeLevel;

public class Application {
    public static void main(String[] args) {
        University university = new University("CH.U.I.");
        university.addStudent(new Student("Andrew Kostenko", KnowledgeLevel.INTERMEDIATE));
        university.addStudent(new Student("Julia Veselkina", KnowledgeLevel.UPPER_INTERMEDIATE));
        university.addStudent(new Student("Maria Perechrest", KnowledgeLevel.ADVANCED));

        Internship internship = new Internship("Interlink", university.getStudentsList());
        System.out.println("List of internship's students:");
        System.out.print(internship.getStudents());
    }
}

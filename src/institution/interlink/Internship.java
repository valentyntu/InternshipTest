package institution.interlink;

import institution.University;
import person.Student;

import java.util.ArrayList;
import java.util.List;

public class Internship {

    private String name;
    private List<Student> studentsList;
    private University studentsOrigin;

    public Internship(String name) {
        this.name = name;
        studentsList = new ArrayList<>();
    }

    public Internship(String name, University university) {
        this(name);
        this.studentsOrigin = university;
        university.getStudentsList().forEach(this::addStudent);
    }

    public void addStudent(Student student) {
        if (student.getKnowledgeLevel().ordinal() > studentsOrigin.getAverageLevel().ordinal()) {
            studentsList.add(student);
        }
    }

    public String getStudents() {
        StringBuilder result = new StringBuilder();
        studentsList.forEach(student -> result.append(student).append("\n"));
        return result.toString();
    }

    public void printStudents() {
        System.out.println("List of internship's students:");
        System.out.print(getStudents());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

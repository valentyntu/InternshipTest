package institution.interlink;

import institution.KnowledgeSource;
import institution.University;
import person.Student;

import java.util.ArrayList;
import java.util.List;

public class Internship implements KnowledgeSource {

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

    @Override
    public void grantKnowledge(Student student) {
        if (studentsList.contains(student)) {
            student.addTheoreticalKnowledge(20.0);
            student.addPracticalKnowledge(30.0);
        }
    }
}

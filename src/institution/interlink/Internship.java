package institution.interlink;

import person.Student;
import person.consciousness.KnowledgeLevel;

import java.util.ArrayList;
import java.util.List;

public class Internship {

    private String name;
    private List<Student> studentsList;

    public Internship(String name) {
        this.name = name;
        studentsList = new ArrayList<>();
    }

    public Internship(String name, List<Student> students) {
        this(name);
        students.forEach(this::addStudent);
    }

    public void addStudent(Student student) {
        if (student.getKnowledgeLevel().ordinal() >= KnowledgeLevel.UPPER_INTERMEDIATE.ordinal()) {
            studentsList.add(student);
        }
    }

    public String getStudents() {
        StringBuilder result = new StringBuilder();
        studentsList.forEach(student -> result.append(student).append("\n"));
        return result.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

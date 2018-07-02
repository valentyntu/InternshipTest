package institution;

import person.Student;
import person.consciousness.KnowledgeLevel;
import person.development.DevelopmentPlan;

import java.util.ArrayList;
import java.util.List;

public class University implements KnowledgeSource {
    private String name;
    private List<Student> studentsList;
    private DevelopmentPlan developmentPlan;

    public University(String name) {
        this.name = name;
        studentsList = new ArrayList<>();
    }

    public void addStudent(Student student) {
        studentsList.add(student);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public KnowledgeLevel getAverageLevel() {
        KnowledgeLevel averageLevel;
        if (!studentsList.isEmpty()) {
            int levelsSum = studentsList.stream().mapToInt(student -> student.getKnowledgeLevel().ordinal()).sum();
            averageLevel = KnowledgeLevel.values()[Math.round((float) levelsSum / (float) studentsList.size())];
        } else {
            averageLevel = null;
        }
        return averageLevel;
    }

    public void setStudents(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    @Override
    public void grantKnowledge(Student student) {
        if (studentsList.contains(student)) {
            student.addTheoreticalKnowledge(10.0);
            student.addPracticalKnowledge(2.5);
        }
    }

    public DevelopmentPlan getDevelopmentPlan() {
        return developmentPlan;
    }

    public void setDevelopmentPlan(DevelopmentPlan developmentPlan) {
        this.developmentPlan = developmentPlan;
        studentsList.forEach(student -> student.mergeDevelopmentPlans(developmentPlan));
    }
}

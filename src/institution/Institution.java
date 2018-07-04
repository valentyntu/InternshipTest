package institution;

import person.Student;
import person.consciousness.KnowledgeLevel;
import person.development.DevelopmentMeasure;
import person.development.DevelopmentPlan;

import java.util.ArrayList;
import java.util.List;

public class Institution implements KnowledgeSource {
    private String name;
    private List<Student> studentsList;
    private DevelopmentPlan developmentPlan;

    private Double practicalKnowledgePerDay;
    private Double theoreticalKnowledgePerDay;

    public Institution(String name) {
        this.name = name;
        studentsList = new ArrayList<>();
        developmentPlan = new DevelopmentPlan();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPracticalKnowledgePerDay() {
        return practicalKnowledgePerDay;
    }

    public void setPracticalKnowledgePerDay(Double practicalKnowledgePerDay) {
        this.practicalKnowledgePerDay = practicalKnowledgePerDay;
    }

    public Double getTheoreticalKnowledgePerDay() {
        return theoreticalKnowledgePerDay;
    }

    public void setTheoreticalKnowledgePerDay(Double theoreticalKnowledgePerDay) {
        this.theoreticalKnowledgePerDay = theoreticalKnowledgePerDay;
    }

    public String getStudents() {
        StringBuilder result = new StringBuilder();
        studentsList.forEach(student -> result.append(student).append("\n"));
        return result.toString();
    }

    public void printStudents() {
        System.out.printf("List of %s's students:\n", name);
        System.out.print(getStudents());
        System.out.println();
    }

    public DevelopmentPlan getDevelopmentPlan() {
        return developmentPlan;
    }

    @Override
    public void grantKnowledge(Student student) {
        grantKnowledge(
                student,
                getPracticalKnowledgePerDay(),
                getTheoreticalKnowledgePerDay()
        );
    }

    public void grantKnowledge(Student student, Double practicalKnowledge, Double theoreticalKnowledge){
        if (studentsList.contains(student)) {
            student.addPracticalKnowledge(practicalKnowledge);
            student.addTheoreticalKnowledge(theoreticalKnowledge);
        }
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public void addDevelopmentMeasureToPlan(DevelopmentMeasure measure) {
        developmentPlan.addMeasure(measure);
        mergeDevelopmentPlansWithStudents();
    }

    public void setDevelopmentPlan(DevelopmentPlan developmentPlan) {
        this.developmentPlan = developmentPlan;
        mergeDevelopmentPlansWithStudents();
    }

    private void mergeDevelopmentPlansWithStudents() {
        studentsList.forEach(student -> student.mergeDevelopmentPlans(developmentPlan));
    }

    public KnowledgeLevel getAverageLevel() {
        KnowledgeLevel averageLevel;
        if (!getStudentsList().isEmpty()) {
            int levelsSum = getStudentsList().stream().mapToInt(student -> student.getKnowledgeLevel().ordinal()).sum();
            averageLevel = KnowledgeLevel.values()[Math.round((float) levelsSum / (float) getStudentsList().size())];
        } else {
            averageLevel = null;
        }
        return averageLevel;
    }

    public void addStudent(Student student) {
        getStudentsList().add(student);
        student.mergeDevelopmentPlans(getDevelopmentPlan());
    }

    @Override
    public String toString() {
        return getName();
    }
}
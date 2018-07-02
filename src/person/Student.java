package person;

import institution.KnowledgeSource;
import person.consciousness.KnowledgeLevel;

public class Student implements KnowledgeSource {

    private String fullName;
    private Double theoreticalKnowledge;
    private Double practicalKnowledge;
    private Double learningEfficiency;

    public Student(String fullName, Double theoreticalKnowledge, Double practicalKnowledge, Double learningEfficiency) {
        this.fullName = fullName;
        this.theoreticalKnowledge = theoreticalKnowledge;
        this.practicalKnowledge = practicalKnowledge;
        this.learningEfficiency = learningEfficiency;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public KnowledgeLevel getKnowledgeLevel() {
        Double minKnowledgeValue = (theoreticalKnowledge >= practicalKnowledge ? practicalKnowledge : theoreticalKnowledge);
        return KnowledgeLevel.getKnowledgeLevel(minKnowledgeValue);
    }

    public void practice(Double taskComplexity) {
        addPracticalKnowledge(taskComplexity);
    }

    public void addPracticalKnowledge(Double amount) {
        this.practicalKnowledge += amount * learningEfficiency;
    }

    public void addTheoreticalKnowledge(Double amount) {
        this.theoreticalKnowledge += amount * learningEfficiency;
    }

    public Double getTheoreticalKnowledge() {
        return theoreticalKnowledge;
    }

    public Double getPracticalKnowledge() {
        return practicalKnowledge;
    }

    public Double getLearningEfficiency() {
        return learningEfficiency;
    }

    @Override
    public String toString() {
        return getFullName();
    }

    @Override
    public void grantKnowledge(Student student) {
        student.addTheoreticalKnowledge(this.getTheoreticalKnowledge() * 0.01);
    }
}

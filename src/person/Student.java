package person;

import institution.KnowledgeSource;
import person.consciousness.KnowledgeLevel;
import person.development.DevelopmentMeasure;
import person.development.DevelopmentPlan;

import java.time.LocalDate;

public class Student extends Creature implements KnowledgeSource {

    private String fullName;
    private Double theoreticalKnowledge;
    private Double practicalKnowledge;
    private Double learningEfficiency;
    private DevelopmentPlan developmentPlan;

    private boolean hasLaptop;

    public Student(String fullName, Double theoreticalKnowledge, Double practicalKnowledge, Double learningEfficiency) {
        this.fullName = fullName;
        this.theoreticalKnowledge = theoreticalKnowledge;
        this.practicalKnowledge = practicalKnowledge;
        this.learningEfficiency = learningEfficiency;
        hasLaptop = true;
        this.developmentPlan = new DevelopmentPlan();
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
        double before = practicalKnowledge;
        this.practicalKnowledge += amount * learningEfficiency;
        System.out.printf("\tpr %6.2f -> %6.2f %s\n",
                before, practicalKnowledge, getKnowledgeLevel());
    }

    public void addTheoreticalKnowledge(Double amount) {
        double before = theoreticalKnowledge;
        this.theoreticalKnowledge += amount * learningEfficiency;
        System.out.printf("\tth %6.2f -> %6.2f %s\n",
                before, theoreticalKnowledge, getKnowledgeLevel());
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

    public boolean hasLaptop() {
        return hasLaptop;
    }

    public void setHasLaptop(boolean hasLaptop) {
        this.hasLaptop = hasLaptop;
    }

    public DevelopmentPlan getDevelopmentPlan() {
        return developmentPlan;
    }

    public void addDevelopmentMeasure(DevelopmentMeasure developmentMeasure) {
        this.developmentPlan.getMeasures().add(developmentMeasure);
    }

    public void mergeDevelopmentPlans(DevelopmentPlan developmentPlan) {
        this.developmentPlan.getMeasures().addAll(developmentPlan.getMeasures());
    }

    @Override
    public String toString() {
        return getFullName();
    }

    @Override
    public void grantKnowledge(Student student) {
        student.addTheoreticalKnowledge(this.getTheoreticalKnowledge() * 0.01);
        student.addPracticalKnowledge(this.getTheoreticalKnowledge() * 0.03);
    }

    public void increaseLearningEfficiency(double increment) {
        if (learningEfficiency < 1 && learningEfficiency + increment < 1) {
            learningEfficiency += increment;
        }
    }

    public void workOnDevelopmentPlan(LocalDate date) {
        developmentPlan.workByPlan(this, date);
    }
}

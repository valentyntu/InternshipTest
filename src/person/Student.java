package person;

import institution.KnowledgeSource;
import person.consciousness.KnowledgeLevel;
import person.development.DevelopmentMeasure;
import person.development.DevelopmentPlan;

public class Student implements KnowledgeSource {

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

    public void onScheduleTaskEnd(DevelopmentMeasure measure){
        measure.getKnowledgeSource().grantKnowledge(this);
    }
}

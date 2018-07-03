package institution;

import person.Student;
import person.consciousness.KnowledgeLevel;
import person.development.DevelopmentMeasure;
import person.development.DevelopmentPlan;

import java.util.ArrayList;
import java.util.List;

public class University extends Institution {

    public University(String name) {
        super(name);
    }

    public void addStudent(Student student) {
        getStudentsList().add(student);
        student.mergeDevelopmentPlans(getDevelopmentPlan());
    }

    @Override
    public void grantKnowledge(Student student) {
        if (getStudentsList().contains(student)) {
            student.addTheoreticalKnowledge(1.0);
            student.addPracticalKnowledge(0.3);
        }
    }
}

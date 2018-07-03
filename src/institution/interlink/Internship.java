package institution.interlink;

import institution.Institution;
import institution.University;
import person.Student;

public class Internship extends Institution {

    private University studentsOrigin;

    public Internship(String name, University university) {
        super(name);
        this.studentsOrigin = university;
        university.getStudentsList().forEach(this::addStudent);
    }

    public void addStudent(Student student) {
        if (student.getKnowledgeLevel().ordinal() > studentsOrigin.getAverageLevel().ordinal()) {
            getStudentsList().add(student);
            student.mergeDevelopmentPlans(getDevelopmentPlan());
        }
    }

    @Override
    public void grantKnowledge(Student student) {
        grantKnowledge(student, 2.0, 1.0);
    }
}

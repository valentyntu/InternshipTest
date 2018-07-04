package institution.interlink;

import institution.Institution;
import person.Student;

public class Internship extends Institution {

    private Institution studentsOrigin;

    public Internship(String name) {
        super(name);
        setPracticalKnowledgePerDay(2.0);
        setTheoreticalKnowledgePerDay(1.0);
    }

    public void addStudent(Student student) {
        if (student.getKnowledgeLevel().ordinal() > studentsOrigin.getAverageLevel().ordinal()) {
            getStudentsList().add(student);
            student.mergeDevelopmentPlans(getDevelopmentPlan());
        }
    }

    public void addStudentsFrom(Institution institution) {
        this.studentsOrigin = institution;
        institution.getStudentsList().forEach(this::addStudent);
    }
}

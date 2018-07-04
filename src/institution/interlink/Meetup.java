package institution.interlink;

import institution.Institution;
import person.Student;

public class Meetup extends Institution {

    private boolean hasInteractive;

    public Meetup(String name, boolean hasInteractive) {
        super(name);
        this.hasInteractive = hasInteractive;
        setPracticalKnowledgePerDay(1.0);
        setTheoreticalKnowledgePerDay(1.0);
    }

    public boolean hasInteractive() {
        return hasInteractive;
    }

    public void setHasInteractive(boolean hasInteractive) {
        this.hasInteractive = hasInteractive;
    }

    @Override
    public void grantKnowledge(Student student) {
        student.addTheoreticalKnowledge(hasInteractive
                ? getTheoreticalKnowledgePerDay() * 1.5
                : getPracticalKnowledgePerDay());
        if (student.hasLaptop()) {
            student.addPracticalKnowledge(getTheoreticalKnowledgePerDay());
        }
    }
}

package institution.interlink;

import institution.KnowledgeSource;
import person.Student;

public class Meetup implements KnowledgeSource {

    private boolean hasInteractive;

    public Meetup(boolean hasInteractive) {
        this.hasInteractive = hasInteractive;
    }

    public boolean hasInteractive() {
        return hasInteractive;
    }

    public void setHasInteractive(boolean hasInteractive) {
        this.hasInteractive = hasInteractive;
    }

    @Override
    public void grantKnowledge(Student student) {
        student.addTheoreticalKnowledge(hasInteractive ? 15.0 : 10.0);
        if (student.hasLaptop()) {
            student.addPracticalKnowledge(5.0);
        }
    }
}

package institution.interlink;

import institution.Institution;
import person.Student;

public class Meetup extends Institution {

    private boolean hasInteractive;

    public Meetup(String name, boolean hasInteractive) {
        super(name);
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

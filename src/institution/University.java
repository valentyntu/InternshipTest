package institution;

import person.Student;

public class University extends Institution {

    public University(String name) {
        super(name);
    }

    @Override
    public void grantKnowledge(Student student) {
        grantKnowledge(student, 0.3, 1.0);
    }
}

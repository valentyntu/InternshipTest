package institution.interlink;

import institution.KnowledgeSource;
import person.Student;

public class Meetup implements KnowledgeSource {

    @Override
    public void grantKnowledge(Student student) {
        student.addTheoreticalKnowledge(15.0);
        if (student.hasLaptop()) {
            student.addPracticalKnowledge(5.0);
        }
    }
}

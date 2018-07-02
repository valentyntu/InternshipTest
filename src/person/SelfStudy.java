package person;

import institution.KnowledgeSource;

public class SelfStudy implements KnowledgeSource {

    @Override
    public void grantKnowledge(Student student) {
        student.addTheoreticalKnowledge(1.0);
        student.addPracticalKnowledge(2.0);
    }
}

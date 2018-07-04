package person;

import institution.KnowledgeSource;

import java.util.Random;

public class SelfDevelopment implements KnowledgeSource {

    @Override
    public void grantKnowledge(Student student) {
        student.addTheoreticalKnowledge(1.0);
        student.practice((double) new Random().nextInt(4));
        student.increaseLearningEfficiency(new Random().nextInt(10) / 1000.0);
    }
}

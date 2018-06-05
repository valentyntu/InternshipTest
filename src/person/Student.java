package person;

import person.consciousness.KnowledgeLevel;

import java.util.Random;

public class Student {

    private String fullName;
    private KnowledgeLevel knowledgeLevel;

    public Student(String fullName) {
        this.fullName = fullName;
        this.knowledgeLevel = KnowledgeLevel.values()[
                new Random().nextInt(KnowledgeLevel.values().length - 1)
                ];
    }

    public Student(String fullName, KnowledgeLevel knowledgeLevel) {
        this.fullName = fullName;
        this.knowledgeLevel = knowledgeLevel;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public KnowledgeLevel getKnowledgeLevel() {
        return knowledgeLevel;
    }

    public void setKnowledgeLevel(KnowledgeLevel knowledgeLevel) {
        this.knowledgeLevel = knowledgeLevel;
    }

    @Override
    public String toString() {
        return getFullName();
    }
}

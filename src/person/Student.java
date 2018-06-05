package person;

import person.consciousness.KnowledgeLevel;

public class Student {

    private String fullName;
    private KnowledgeLevel knowledgeLevel;

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
}

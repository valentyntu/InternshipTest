package person.development;

import institution.KnowledgeSource;

public class DevelopmentMeasure {

    private Schedule schedule;
    private KnowledgeSource knowledgeSource;

    public DevelopmentMeasure(Schedule schedule, KnowledgeSource knowledgeSource) {
        this.schedule = schedule;
        this.knowledgeSource = knowledgeSource;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public KnowledgeSource getKnowledgeSource() {
        return knowledgeSource;
    }

    public void setKnowledgeSource(KnowledgeSource knowledgeSource) {
        this.knowledgeSource = knowledgeSource;
    }
}

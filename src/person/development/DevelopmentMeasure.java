package person.development;

import institution.Institution;
import institution.KnowledgeSource;
import person.Student;

import java.time.LocalDate;

public class DevelopmentMeasure {

    private Schedule schedule;
    private KnowledgeSource knowledgeSource;

    public DevelopmentMeasure(Schedule schedule, KnowledgeSource knowledgeSource) {
        this.schedule = schedule;
        this.knowledgeSource = knowledgeSource;
    }

    public void apply(Student student, LocalDate date) {
        if (schedule.isApplicableOn(date, student)) {
            System.out.printf("[%s", knowledgeSource.getClass().getSimpleName());
            if (knowledgeSource instanceof Institution) {
                Institution institution = (Institution) knowledgeSource;
                System.out.printf(": %s", institution.getName());
            }
            System.out.print("]\n");
            knowledgeSource.grantKnowledge(student);
        }
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

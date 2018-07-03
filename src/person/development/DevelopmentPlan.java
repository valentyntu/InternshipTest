package person.development;

import person.Student;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DevelopmentPlan {

    private Set<DevelopmentMeasure> measures;

    public DevelopmentPlan() {
        this.measures = new HashSet<>();
    }

    public Set<DevelopmentMeasure> getMeasures() {
        return measures;
    }

    public void addMeasure(DevelopmentMeasure developmentMeasure) {
        this.measures.add(developmentMeasure);
    }

    public void workByPlan(Student student, LocalDate currentDate) {
        measures.forEach(developmentMeasure -> developmentMeasure.apply(student, currentDate));
    }
}

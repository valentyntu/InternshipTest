package person.development;

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
}

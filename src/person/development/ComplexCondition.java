package person.development;

import java.util.Set;

public class ComplexCondition implements ScheduleCondition {
    private Set<ScheduleCondition> conditions;

    @Override
    public void add(ScheduleCondition condition) {
        conditions.add(condition);
    }

    @Override
    public void remove(ScheduleCondition condition) {
        conditions.remove(condition);
    }
}

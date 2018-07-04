package person.development;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class ComplexCondition implements ScheduleCondition {
    private Set<ScheduleCondition> conditions;

    public ComplexCondition() {
        conditions = new HashSet<>();
    }

    @Override
    public void add(ScheduleCondition condition) {
        conditions.add(condition);
    }

    @Override
    public void remove(ScheduleCondition condition) {
        conditions.remove(condition);
    }

    @Override
    public boolean contains(ScheduleCondition condition) {
        if (conditions.contains(condition)) {
            return true;
        } else {
            return conditions.stream().anyMatch(condition1 -> condition1.contains(condition));
        }
    }

    @Override
    public boolean fitsDate(LocalDate date) {
        return conditions.stream().allMatch(condition -> condition.fitsDate(date));
    }
}

package person.consciousness;

import java.util.Arrays;
import java.util.List;

public enum KnowledgeLevel {
    BEGINNER(0), INTERMEDIATE(30), UPPER_INTERMEDIATE(50), ADVANCED(75);

    private Double knowledgeThreshold;

    KnowledgeLevel(double knowledgeThreshold) {
        this.knowledgeThreshold = knowledgeThreshold;
    }

    public Double getKnowledgeThreshold() {
        return knowledgeThreshold;
    }

    public static KnowledgeLevel getKnowledgeLevel(Double knowledgeValue) {
        List<KnowledgeLevel> levelList = Arrays.asList(KnowledgeLevel.values());
        try {
            return levelList.stream()
                    .filter(knowledgeLevel -> knowledgeLevel.getKnowledgeThreshold() <= knowledgeValue
                            && levelList.get(levelList.indexOf(knowledgeLevel) + 1).getKnowledgeThreshold() > knowledgeValue
                    ).findFirst().get();
        } catch (ArrayIndexOutOfBoundsException e) {
            return levelList.get(levelList.size() - 1);
        }

    }
}

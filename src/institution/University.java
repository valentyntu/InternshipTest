package institution;

public class University extends Institution {

    public University(String name) {
        super(name);
        setPracticalKnowledgePerDay(0.3);
        setTheoreticalKnowledgePerDay(1.0);
    }
}

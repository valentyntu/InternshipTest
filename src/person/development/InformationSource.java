package person.development;

public class InformationSource {

    private String name;
    private Double theoreticalKnowledgeGain;
    private Double practicalKnowledgeGain;

    public InformationSource(String name, Double theoreticalKnowledgeGain, Double practicalKnowledgeGain) {
        this.name = name;
        this.theoreticalKnowledgeGain = theoreticalKnowledgeGain;
        this.practicalKnowledgeGain = practicalKnowledgeGain;
    }

    public InformationSource(String line) {
        try {
            String values[] = line.split(" ");
            this.name = values[0];
            this.theoreticalKnowledgeGain = Double.parseDouble(values[1]);
            this.practicalKnowledgeGain = Double.parseDouble(values[2]);
        } catch (Exception e) {
            System.out.println("Could not parse information source");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTheoreticalKnowledgeGain() {
        return theoreticalKnowledgeGain;
    }

    public void setTheoreticalKnowledgeGain(Double theoreticalKnowledgeGain) {
        this.theoreticalKnowledgeGain = theoreticalKnowledgeGain;
    }

    public Double getPracticalKnowledgeGain() {
        return practicalKnowledgeGain;
    }

    public void setPracticalKnowledgeGain(Double practicalKnowledgeGain) {
        this.practicalKnowledgeGain = practicalKnowledgeGain;
    }
}

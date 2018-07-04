package person.development;

import institution.KnowledgeSource;
import person.Student;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SelfDevelopment implements KnowledgeSource {

    public static final String INFORMATION_SOURCE_FILE_NAME = "sources";
    private List<InformationSource> informationSources;

    public SelfDevelopment() {
        try {
            this.informationSources = loadInformationSources(getClass().getResource(INFORMATION_SOURCE_FILE_NAME).toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private List<InformationSource> loadInformationSources(URI targetFile) {
        List<InformationSource> informationSources = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(targetFile))) {
            stream.forEach(line -> informationSources.add(new InformationSource(line)));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not find or load file!");
        }
        return informationSources;
    }

    @Override
    public void grantKnowledge(Student student) {
        InformationSource source = informationSources.get(new Random().nextInt(informationSources.size()));
        student.addTheoreticalKnowledge(source.getTheoreticalKnowledgeGain());
        student.addPracticalKnowledge(source.getPracticalKnowledgeGain());
        student.increaseLearningEfficiency(new Random().nextInt(10) / 1000.0);
    }
}

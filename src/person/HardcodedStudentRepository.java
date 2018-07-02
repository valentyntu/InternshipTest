package person;

import java.util.ArrayList;
import java.util.List;

import static person.consciousness.KnowledgeLevel.ADVANCED;
import static person.consciousness.KnowledgeLevel.BEGINNER;
import static person.consciousness.KnowledgeLevel.INTERMEDIATE;
import static person.consciousness.KnowledgeLevel.UPPER_INTERMEDIATE;

public class HardcodedStudentRepository implements StudentRepository {

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Mikolai Kostenko",
                BEGINNER.getKnowledgeThreshold(),
                BEGINNER.getKnowledgeThreshold(),
                0.1));
        students.add(new Student("Kostyantin Scheulov",
                BEGINNER.getKnowledgeThreshold(),
                BEGINNER.getKnowledgeThreshold(),
                0.19));
        students.add(new Student("Andrew Kostenko",
                INTERMEDIATE.getKnowledgeThreshold(),
                INTERMEDIATE.getKnowledgeThreshold(),
                0.25));
        students.add(new Student("Julia Veselkina",
                UPPER_INTERMEDIATE.getKnowledgeThreshold(),
                UPPER_INTERMEDIATE.getKnowledgeThreshold(),
                0.6));
        students.add(new Student("Maria Perechrest",
                ADVANCED.getKnowledgeThreshold(),
                ADVANCED.getKnowledgeThreshold(),
                0.7));
        return students;
    }
}

package person;

import java.util.ArrayList;
import java.util.List;

import static person.consciousness.KnowledgeLevel.ADVANCED;
import static person.consciousness.KnowledgeLevel.BEGINNER;
import static person.consciousness.KnowledgeLevel.INTERMEDIATE;
import static person.consciousness.KnowledgeLevel.UPPER_INTERMEDIATE;

public class HardcodedStudentRepository implements StudentRepository {

    private static List<Student> students = createStudents();

    @Override
    public List<Student> getStudents() {
        return students;
    }

    private static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "Mykolai K.",
                BEGINNER.getKnowledgeThreshold(),
                BEGINNER.getKnowledgeThreshold(),
                0.4));
        students.add(new Student("Kostyantin Sch.",
                BEGINNER.getKnowledgeThreshold(),
                BEGINNER.getKnowledgeThreshold(),
                0.42));
        students.add(new Student("Max D.",
                INTERMEDIATE.getKnowledgeThreshold(),
                INTERMEDIATE.getKnowledgeThreshold(),
                0.5));
        students.add(new Student("Anton Ch.",
                UPPER_INTERMEDIATE.getKnowledgeThreshold(),
                UPPER_INTERMEDIATE.getKnowledgeThreshold(),
                0.75));
        students.add(new Student("Alex T.",
                ADVANCED.getKnowledgeThreshold(),
                ADVANCED.getKnowledgeThreshold(),
                0.7));
        return students;
    }
}

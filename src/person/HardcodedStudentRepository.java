package person;

import person.consciousness.KnowledgeLevel;

import java.util.ArrayList;
import java.util.List;

public class HardcodedStudentRepository implements StudentRepository {

    @Override
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Mikolai Kostenko", KnowledgeLevel.BEGINNER));
        students.add(new Student("Kostyantin Scheulov", KnowledgeLevel.BEGINNER));
        students.add(new Student("Andrew Kostenko", KnowledgeLevel.INTERMEDIATE));
        students.add(new Student("Julia Veselkina", KnowledgeLevel.UPPER_INTERMEDIATE));
        students.add(new Student("Maria Perechrest", KnowledgeLevel.ADVANCED));
        return students;
    }
}

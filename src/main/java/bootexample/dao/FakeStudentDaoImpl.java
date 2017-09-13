package bootexample.dao;

import bootexample.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HP on 09.09.2017.
 */
@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Marco Polo", "Computer Science"));
                put(2, new Student(2, "David Guetta", "Finance"));
                put(3, new Student(3, "Al Pachino", "Mathematic"));

            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return students.get(id);
    }

    @Override
    public void deleteById(int id) {
        this.students.remove(id);
    }

    @Override
    public void update(Student student) {
        students.put(student.getId(), student);
    }

}

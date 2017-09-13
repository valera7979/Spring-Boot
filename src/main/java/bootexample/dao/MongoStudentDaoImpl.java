package bootexample.dao;

import bootexample.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by HP on 11.09.2017.
 */
@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Marco Polo", "Computer Science"));

            }
        };
    }


    @Override
    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Student student) {

    }
}

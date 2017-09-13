package bootexample.dao;

import bootexample.entity.Student;

import java.util.Collection;

/**
 * Created by HP on 11.09.2017.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteById(int id);

    void update(Student student);
}

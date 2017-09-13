package bootexample.service;

import bootexample.dao.FakeStudentDaoImpl;
import bootexample.dao.StudentDao;
import bootexample.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by HP on 09.09.2017.
 */
@Service
public class StudentService {

    @Autowired
    @Qualifier("mongoData")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return studentDao.getStudentById(id);
    }

    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    public void update(Student student) {
        studentDao.update(student);
    }
}

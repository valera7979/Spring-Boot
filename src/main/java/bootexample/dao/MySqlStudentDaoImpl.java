package bootexample.dao;

import bootexample.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by HP on 13.09.2017.
 */
@Repository
@Qualifier("mySqlData")
public class MySqlStudentDaoImpl implements StudentDao {

    private static class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Student> getAllStudents() {
        List<Student> students = jdbcTemplate.query("SELECT id, name, course FROM students"
                , new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        Student student = jdbcTemplate.queryForObject("SELECT id, name, course FROM students WHERE id=?", new StudentRowMapper(), id);
            return student;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Student student) {

    }
}

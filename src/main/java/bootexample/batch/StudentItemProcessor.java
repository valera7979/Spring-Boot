package bootexample.batch;

/**
 * Created by Valera on 15.09.2017.
 */
import bootexample.entity.Student;
import org.springframework.batch.item.ItemProcessor;

public class StudentItemProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(final Student student) throws Exception {
        final String name = student.getName().toUpperCase();
        final String course = student.getCourse().toUpperCase();
        final int id = student.getId();

        final Student transformedStudent = new Student(id, name, course);

        return transformedStudent;
    }

}
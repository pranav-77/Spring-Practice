package studentJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import studentJdbc.model.Student;
import studentJdbc.repository.StudentRepository;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentRepository repository = context.getBean(StudentRepository.class);

        repository.addStudent(new Student(1, "pranav", 87));
        repository.addStudent(new Student(2, "alan", 76));

        List<Student> students = repository.getAllData();
        students.forEach(System.out::println);

        Student student = repository.getStudent(1);
        System.out.println(student);

        repository.update(2, 99);
        System.out.println("Updated");
        Student student1 = repository.getStudent(2);
        System.out.println(student1);

        repository.delete(2);
        System.out.println("Deleted");

//        repository.truncate();
//        System.out.println("Truncated");
    }
}

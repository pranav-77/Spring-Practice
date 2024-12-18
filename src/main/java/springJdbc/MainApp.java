package springJdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springJdbc.model.Employee;
import springJdbc.repository.EmployeeRepository;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeRepository repository = context.getBean(EmployeeRepository.class);

        repository.addEmployee(new Employee(0, "Pranav", 50000));
        repository.addEmployee(new Employee(0, "Alan", 60000));

        System.out.println("All Employees:");
        List<Employee> employees = repository.getAllEmployees();
        employees.forEach(emp -> System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary()));

        System.out.println("Employee with ID 1:");
        Employee emp = repository.getEmployeeById(1);
        System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());

        repository.updateEmployeeSalary(1, 55000);
        System.out.println("Updated Employee with ID 1:");
        Employee updatedEmp = repository.getEmployeeById(1);
        System.out.println(updatedEmp.getId() + " " + updatedEmp.getName() + " " + updatedEmp.getSalary());

        repository.deleteEmployee(2);
        System.out.println("Employees after Deletion:");
        repository.getAllEmployees().forEach(e -> System.out.println(e.getId() + " " + e.getName()));
    }
}

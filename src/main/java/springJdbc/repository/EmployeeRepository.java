package springJdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springJdbc.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

//@Repository
public class EmployeeRepository {

    private JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addEmployee(Employee employee) {
        String sql = "INSERT INTO Employee (name, salary) VALUES (?, ?)";
        return jdbcTemplate.update(sql, employee.getName(), employee.getSalary());
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM Employee";
        return jdbcTemplate.query(sql, this::mapRow);
    }

    public Employee getEmployeeById(int id) {
        String sql = "SELECT * FROM Employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, this::mapRow, id);
    }

    public int updateEmployeeSalary(int id, double salary) {
        String sql = "UPDATE Employee SET salary = ? WHERE id = ?";
        return jdbcTemplate.update(sql, salary, id);
    }

    public int deleteEmployee(int id) {
        String sql = "DELETE FROM Employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    private Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
    }
}

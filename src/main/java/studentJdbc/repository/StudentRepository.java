package studentJdbc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import studentJdbc.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbcTemplate;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int addStudent(Student student) {
        String sql = "INSERT INTO STUDENT(rollNo,name,mark) values(?,?,?)";
        return jdbcTemplate.update(sql, student.getRollNo(), student.getName(), student.getMark());
    }

    public List<Student> getAllData() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, this::maprow);
    }

    public Student getStudent(int rollNo) {
        String sql = "select * from student where rollNo=?";
        return jdbcTemplate.queryForObject(sql, this::maprow, rollNo);
    }

    public int update(int rollNo, int mark) {
        String sql = "update student set mark=? where rollNo=?";
        return jdbcTemplate.update(sql, mark, rollNo);
    }

    public int delete(int rollNo) {
        String sql = "Delete from student where rollNo=?";
        return jdbcTemplate.update(sql, rollNo);
    }

    public int truncate() {
        String sql = "Truncate table student";
        return jdbcTemplate.update(sql);
    }

    public Student maprow(ResultSet rs, int rowNum) throws SQLException {
        return new Student(rs.getInt("rollNo"), rs.getString("name"), rs.getInt("mark"));
    }
}

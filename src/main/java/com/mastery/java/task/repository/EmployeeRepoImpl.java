package com.mastery.java.task.repository;

import com.mastery.java.task.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Employee findById(Long id) {
        String sql = "select * from employee where employee_id=?";
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Employee.class), id);
    }

    @Override
    public List<Employee> findAll() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
    }

    @Override
    public int save(Employee employee) {
        String sql = "insert into employee (first_name, last_name, department_id, job_title, gender, date_of_birth) values (?,?,?,?,cast(? as enum_gender),?)";
        return jdbcTemplate.update(sql,
                employee.getFirstName(), employee.getLastName(),
                employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender().name(), employee.getDateOfBirth()
        );
    }

    @Override
    public int update(Employee employee, Long id) {
        String sql = "update employee set first_name=?, last_name=?, department_id=?, job_title=?, gender=cast(? as enum_gender), date_of_birth=? where employee_id=?";
        return jdbcTemplate.update(sql,
                employee.getFirstName(), employee.getLastName(),
                employee.getDepartmentId(), employee.getJobTitle(),
                employee.getGender().name(), employee.getDateOfBirth(), id
        );
    }

    @Override
    public int deleteById(Long id) {
        String sql = "delete from employee where employee_id=?";
        return jdbcTemplate.update(sql, id);
    }
}

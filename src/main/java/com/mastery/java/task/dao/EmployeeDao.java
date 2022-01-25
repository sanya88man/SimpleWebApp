package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee findById(Long id);

    List<Employee> findAll();

    int save(Employee employee);

    int update(Employee employee, Long id);

    int deleteById(Long id);
}

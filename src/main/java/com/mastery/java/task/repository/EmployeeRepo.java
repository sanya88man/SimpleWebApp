package com.mastery.java.task.repository;

import com.mastery.java.task.model.Employee;

import java.util.List;

public interface EmployeeRepo {
    Employee findById(Long id);

    List<Employee> findAll();

    int save(Employee employee);

    int update(Employee employee, Long id);

    int deleteById(Long id);
}

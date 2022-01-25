package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;

import java.util.List;

public interface EmployeeService {
    Employee showEmployee(Long id);

    List<Employee> showAllEmployees();

    void saveEmployee(Employee employee);

    void updateEmployee(Employee employee, Long id);

    void deleteEmployee(Long id);
}

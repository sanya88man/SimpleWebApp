package com.mastery.java.task.service;

import com.mastery.java.task.repository.EmployeeRepo;
import com.mastery.java.task.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee showEmployee(Long id) {
        log.info("In EmployeeServiceImpl showEmployee id = {}", id);
        return employeeRepo.findById(id);
    }

    @Override
    public List<Employee> showAllEmployees() {
        log.info("In EmployeeServiceImpl showAllEmployees");
        return employeeRepo.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        log.info("In EmployeeServiceImpl saveEmployee {}", employee);
        employeeRepo.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee, Long id) {
        log.info("In EmployeeServiceImpl updateEmployee {}, id = {}", employee, id);
        employeeRepo.update(employee, id);
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("In EmployeeServiceImpl deleteEmployee id = {}", id);
        employeeRepo.deleteById(id);
    }
}

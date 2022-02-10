package com.mastery.java.task.controller;

import com.mastery.java.task.model.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeId) {
        if (employeeId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Employee employee = employeeService.showEmployee(employeeId);

        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        if (employeeService.showEmployee(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.showAllEmployees();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}


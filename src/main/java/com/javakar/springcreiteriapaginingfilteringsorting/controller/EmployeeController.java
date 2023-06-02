package com.javakar.springcreiteriapaginingfilteringsorting.controller;

import com.javakar.springcreiteriapaginingfilteringsorting.model.Employee;
import com.javakar.springcreiteriapaginingfilteringsorting.model.EmployeePage;
import com.javakar.springcreiteriapaginingfilteringsorting.model.EmployeeSearchCriteria;
import com.javakar.springcreiteriapaginingfilteringsorting.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("employees")
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping
    public ResponseEntity<Page<Employee>> getEmployees(EmployeePage employeePage,
                                                       EmployeeSearchCriteria employeeSearchCriteria){
        Page<Employee> page = employeeService.getEmployees(employeePage, employeeSearchCriteria);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
}

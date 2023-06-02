package com.javakar.springcreiteriapaginingfilteringsorting.service;


import com.javakar.springcreiteriapaginingfilteringsorting.model.Employee;
import com.javakar.springcreiteriapaginingfilteringsorting.model.EmployeePage;
import com.javakar.springcreiteriapaginingfilteringsorting.model.EmployeeSearchCriteria;
import com.javakar.springcreiteriapaginingfilteringsorting.repository.EmployeeCriteriaRepository;
import com.javakar.springcreiteriapaginingfilteringsorting.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeCriteriaRepository employeeCriteriaRepository;


    public Page<Employee> getEmployees(EmployeePage employeePage,
                                       EmployeeSearchCriteria employeeSearchCriteria){
        return employeeCriteriaRepository.findAllWithFilters(employeePage, employeeSearchCriteria);
    }

    public Employee addEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}

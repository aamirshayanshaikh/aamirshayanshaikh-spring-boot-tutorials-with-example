package com.javakar.springcreiteriapaginingfilteringsorting.repository;

import com.javakar.springcreiteriapaginingfilteringsorting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package com.example.Assessment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Assessment.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

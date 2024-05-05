package com.restapi.apiemployee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.apiemployee.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @SuppressWarnings("null")
    Page<Employee> findAll(Pageable pageable);
    Employee findByFirstName(String firstName);
}

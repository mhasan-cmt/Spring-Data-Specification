package com.devmahmud.springdataspecificationdemo.repository;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployeeRepository extends JpaRepository<Employee, Long>,
        EmployeeCustomRepo, JpaSpecificationExecutor<Employee> {
}

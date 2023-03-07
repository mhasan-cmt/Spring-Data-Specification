package com.devmahmud.springdataspecificationdemo.service;

import com.devmahmud.springdataspecificationdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeByFirstNameAndLastName(String firstname,
                                                     String lastname);
    List<Employee> getAll();
    List<Employee> getEmployeeByFirstNameAndDepartment(String firstname,
                                                       String department);
}

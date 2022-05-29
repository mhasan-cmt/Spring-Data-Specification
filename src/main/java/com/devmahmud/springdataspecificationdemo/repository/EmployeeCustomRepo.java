package com.devmahmud.springdataspecificationdemo.repository;

import com.devmahmud.springdataspecificationdemo.entity.Employee;

import java.util.List;
public interface EmployeeCustomRepo {
    List<Employee> findByFirstNameAndLastName(String firstname,
                                              String lastname);
}

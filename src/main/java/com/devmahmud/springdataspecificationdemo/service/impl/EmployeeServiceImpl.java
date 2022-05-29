package com.devmahmud.springdataspecificationdemo.service.impl;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import com.devmahmud.springdataspecificationdemo.repository.EmployeeRepository;
import com.devmahmud.springdataspecificationdemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployeeByFirstNameAndLastName(String firstname, String lastname) {
        return employeeRepository.findByFirstNameAndLastName(firstname, lastname);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}

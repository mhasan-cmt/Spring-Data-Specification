package com.devmahmud.springdataspecificationdemo.service.impl;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import com.devmahmud.springdataspecificationdemo.repository.EmployeeRepository;
import com.devmahmud.springdataspecificationdemo.service.EmployeeService;
import com.devmahmud.springdataspecificationdemo.specification.EmployeeSpecification;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.devmahmud.springdataspecificationdemo.specification.EmployeeSpecification.hasDepartment;
import static com.devmahmud.springdataspecificationdemo.specification.EmployeeSpecification.hasFirstname;

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

    @Override
    public List<Employee> getEmployeeByFirstNameAndDepartment(String firstname, String department) {
        return employeeRepository.findAll(hasFirstname(firstname).and(hasDepartment(department)));
    }
}

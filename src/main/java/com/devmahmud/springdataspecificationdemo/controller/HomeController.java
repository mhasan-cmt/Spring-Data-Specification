package com.devmahmud.springdataspecificationdemo.controller;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import com.devmahmud.springdataspecificationdemo.repository.EmployeeRepository;
import com.devmahmud.springdataspecificationdemo.service.EmployeeService;

import static com.devmahmud.springdataspecificationdemo.specification.EmployeeSpecification.*;
import static org.springframework.data.jpa.domain.Specification.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {
    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    public HomeController(EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "Hello, world!";
    }

    @GetMapping("/get")
    public List<Employee> getAllEmployee() {
        return employeeService.getAll();
    }

    @GetMapping("/get/{firstname}/{department}")
    public List<Employee> getEmployeeByFirstnameAndLastname(@PathVariable(name = "firstname") String firstname,
                                                            @PathVariable(name = "department") String department) {

        return employeeRepository.findAll(
                where(hasFirstname(firstname).and(hasDepartment(department)))
        );
    }
}

package com.devmahmud.springdataspecificationdemo.controller;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import com.devmahmud.springdataspecificationdemo.repository.EmployeeRepository;
import com.devmahmud.springdataspecificationdemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.devmahmud.springdataspecificationdemo.specification.EmployeeSpecification.hasDepartment;
import static com.devmahmud.springdataspecificationdemo.specification.EmployeeSpecification.hasFirstname;
import static org.springframework.data.jpa.domain.Specification.where;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployee() {
        return employeeService.getAll();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployeeByFirstNameAndDepartment(@RequestParam(name = "department") Optional<String> department,
                                                                              @RequestParam(name = "firstname") Optional<String> firstname) {
        if (department.isPresent() && firstname.isPresent()){
        List<Employee> result = employeeService.getEmployeeByFirstNameAndDepartment(firstname.get(), department.get());
        return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}

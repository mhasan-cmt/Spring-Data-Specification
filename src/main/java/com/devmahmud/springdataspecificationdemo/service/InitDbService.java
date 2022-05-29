package com.devmahmud.springdataspecificationdemo.service;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import com.devmahmud.springdataspecificationdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InitDbService {


    private final EmployeeRepository employeeRepository;

    public InitDbService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void init(){
        if (employeeRepository.count()==0){
        List<Employee> employeeList = new ArrayList<>();
        Employee em1 = new Employee();
        em1.setFirstname("Mahmudul");
        em1.setLastname("hasan");
        em1.setDept("Sales");

        Employee em2 = new Employee();
        em2.setFirstname("Hasan");
        em2.setLastname("Mahmud");
        em2.setDept("Marketing");

        Employee em3 = new Employee();
        em3.setFirstname("Kamal");
        em3.setLastname("Hasan");
        em3.setDept("Marketing");

        employeeList.add(em1);
        employeeList.add(em2);
        employeeList.add(em3);

        employeeRepository.saveAll(employeeList);
        }
    }
}

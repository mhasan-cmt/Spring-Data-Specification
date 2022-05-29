package com.devmahmud.springdataspecificationdemo.specification;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import com.devmahmud.springdataspecificationdemo.entity.Employee_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class EmployeeSpecification {
    public static Specification<Employee> hasFirstname(String firstname) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Employee_.firstname), firstname);
        });
    }
    public static Specification<Employee> containsLastname(String lastname) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(Employee_.lastname),"%"+ lastname);
        });
    }

    public static Specification<Employee> hasDepartment(String department) {
        return ((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(Employee_.dept), department);
        });
    }
}

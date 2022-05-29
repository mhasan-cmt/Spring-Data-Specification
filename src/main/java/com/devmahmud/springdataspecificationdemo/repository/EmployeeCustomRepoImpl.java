package com.devmahmud.springdataspecificationdemo.repository;

import com.devmahmud.springdataspecificationdemo.entity.Employee;
import com.devmahmud.springdataspecificationdemo.entity.Employee_;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class EmployeeCustomRepoImpl implements EmployeeCustomRepo {
    private final EntityManager entityManager;


    public EmployeeCustomRepoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findByFirstNameAndLastName(String firstname, String lastname) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(Employee.class);
        Root<Employee> employee = cq.from(Employee.class);


        Predicate firstnamePredicate = cb.equal(employee.get(Employee_.firstname), firstname);
        Predicate lastnamePredicate = cb.equal(employee.get(Employee_.lastname), lastname);

        cq.where(firstnamePredicate, lastnamePredicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}

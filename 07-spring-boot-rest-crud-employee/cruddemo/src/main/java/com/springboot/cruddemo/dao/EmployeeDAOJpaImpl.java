package com.springboot.cruddemo.dao;
//step 3:
import com.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{
    //define field for entitymanager
    private EntityManager entityManager;

    //define Constructor Injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Employee> findAll(){
        //create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);

        //execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        return employees;
    }
}

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

    //step 8: add methods in dao implimentation

    @Override
    public Employee findById(int theId){
        //find employee
        Employee theEmployee = entityManager.find(Employee.class, theId);

        //return employee
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee){
        //save employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        //return the dbEmployee
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId){
        //find the employee
        Employee theEmployee = entityManager.find(Employee.class, theId);
        //remove the employee
        entityManager.remove(theEmployee);
    }
}

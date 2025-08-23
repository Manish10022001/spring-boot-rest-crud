package com.springboot.cruddemo.rest;


import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.service.EmployeeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//step 4: create rest controller to use DAO
@RestController
@RequestMapping("/api")
public class EmployeeRestController {
//    //define field of emploeeDAO to use
//    private EmployeeDAO employeeDAO;
//
//    //Inject and Destroy: employeeDAO, later will refactor it using service
//
//    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }
//
//    //expose "/employees" and return list of all employees
//    @GetMapping("/employees")
//    public List<Employee> findAll(){
//        return employeeDAO.findAll();
//    } refactor above code to use Service to get single view

    //define field to add reference to EmployeeService
    private EmployeeService employeeService;

    //Inject Constructor
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }
    //expose "/employees" and return list of all employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    //step 11
    //Read a single employee
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - "+employeeId);
        }
        return theEmployee;
    }
}

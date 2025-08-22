package com.springboot.cruddemo.service;
//step :5
import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}

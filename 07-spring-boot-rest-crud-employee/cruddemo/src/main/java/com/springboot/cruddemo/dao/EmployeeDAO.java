package com.springboot.cruddemo.dao;
//step 2:
import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}

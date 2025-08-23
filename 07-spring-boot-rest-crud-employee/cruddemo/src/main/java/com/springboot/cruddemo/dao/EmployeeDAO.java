package com.springboot.cruddemo.dao;
//step 2:
import com.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    //Step 7-> add new methods-> findbyid, add, delete , update
    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}

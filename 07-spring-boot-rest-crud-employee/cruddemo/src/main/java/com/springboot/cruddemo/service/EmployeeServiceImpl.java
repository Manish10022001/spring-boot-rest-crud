package com.springboot.cruddemo.service;
//Step 6
import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    //define field to add reference to EmployeeDAO
    private EmployeeDAO employeeDAO;

    //Inject EmployeeDAO
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }
    @Override
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }

    //step 10: add methods and delegate calls to dao
    @Override
    public Employee findById(int theId){
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional //as we update or insert new values, and gave @transaction here instead of DAO methods
    public Employee save(Employee theEmployee){
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional // as value changes
    public void deleteById(int theId){
        employeeDAO.deleteById(theId);
    }
}

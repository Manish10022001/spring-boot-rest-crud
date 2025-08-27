package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
/* Using Spring data rest:
using spring data rest we can create multiple rest api, without giveing rest controller and service.
spring data rest will scan for jpa repository and automatically create rest endpoints , no coding is required
so delete service and rest as it is no longer required.

For Spring data rest, we need only 3 items
1.entity
2.JpaRepository: EmployeeRepository extends JpaRepository
3.maven pom dependency for: spring-boot-starter-data-rest
 */
//step 2: create employee reposity interface and extend JpaRepository<entity type, primarykey>
public interface EmployeeRepository extends JpaRepository<Employee,Integer > {
    // no need to write any code as we are using SpringData JPA
}
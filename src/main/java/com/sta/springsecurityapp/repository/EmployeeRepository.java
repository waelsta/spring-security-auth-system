package com.sta.springsecurityapp.repository;

import com.sta.springsecurityapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee getEmployeeByEmail(String email);


}

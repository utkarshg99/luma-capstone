package com.luma.luma.Repository;

import org.springframework.data.repository.CrudRepository;
import com.luma.luma.Model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

}

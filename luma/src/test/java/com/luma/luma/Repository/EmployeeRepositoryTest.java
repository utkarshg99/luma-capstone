package com.luma.luma.Repository;

import com.luma.luma.Model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    Employee employee1 = null;
//    Employee employee2 = null;
    Employee newEmployee1 = null;
//    Employee newEmployee2 = null;

    @BeforeEach
    void setUp() {
        employee1 = new Employee();
        employee1.setId("E001");
        employee1.setDoj(new Date());
        employee1.setDob(new Date());
        employee1.setGender('M');
        employee1.setName("Rahul");
        employee1.setDepartment("Sales");
        employee1.setDesignation("Associate");
        newEmployee1 = employeeRepository.save(employee1);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteById("E001");
    }

    @Test
    public void addEmployee(){
        assertThat(newEmployee1).isNotNull();
        assertThat(employee1.getName()).isEqualTo(newEmployee1.getName());
    }

    @Test
    public void getAllEmployees(){
        List<Employee> employeeList = employeeRepository.findAll();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList).anyMatch(c -> c.getName().equals(employee1.getName()));
    }

    @Test
    public void findEmployeeByID(){
        Employee emp1 = employeeRepository.findById(employee1.getId()).orElse(null);
        Employee emp2 = employeeRepository.findById("E002").orElse(null);
        assertThat(emp1).isNotNull();
        assertThat(emp2).isNull();
        assertThat(emp1.getName()).isEqualTo(newEmployee1.getName());
    }

    @Test
    public void deleteByIdTest(){
        Employee emp1 = employeeRepository.findById(employee1.getId()).orElse(null);
        employeeRepository.deleteById(emp1.getId());
        List<Employee> empList = employeeRepository.findAll();
        assertFalse(empList.contains(emp1));
    }
}
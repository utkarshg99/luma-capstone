package com.luma.luma.Service;

import com.luma.luma.Model.Card;
import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Issue;
import com.luma.luma.Model.Item;
import com.luma.luma.Repository.EmployeeRepository;
import com.luma.luma.Repository.IssueRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetItemsTest {

    @InjectMocks
    GetItems getItems;

    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    IssueRepository issueRepository;


    @Test
    void getItems() {
        Employee employee1 = new Employee();
        employee1.setId("E001");
        employee1.setDoj(new Date());
        employee1.setDob(new Date());
        employee1.setGender('M');
        employee1.setName("Rahul");
        employee1.setDepartment("Sales");
        employee1.setDesignation("Associate");
        Optional<Employee> o_emp = Optional.of(employee1);
        when(employeeRepository.findById(Mockito.anyString())).thenReturn(o_emp);

        Item item1 = new Item();
        item1.setId("I001");
        item1.setCategory("Furniture");
        item1.setStatus('Y');
        item1.setDescription("medium brown chair");
        item1.setMake("Wood");
        item1.setValuation(1000);

        Issue issue1 = new Issue();
        issue1.setId("IS001");
        issue1.setIssueDate(new Date());
        issue1.setEid(employee1);
        issue1.setIid(item1);

        List<Issue> issues = new ArrayList<>();
        issues.add(issue1);
        when(issueRepository.findByEid(Mockito.any(Employee.class))).thenReturn(issues);

        List<Item> items = getItems.getItems("E001");
        assertThat(items).isNotNull();
        assertThat(items).hasSize(1);
    }
}
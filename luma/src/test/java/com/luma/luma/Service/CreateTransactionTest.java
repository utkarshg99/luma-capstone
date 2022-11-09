package com.luma.luma.Service;

import com.luma.luma.Controller.DTO.IssueDTO;
import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Issue;
import com.luma.luma.Model.Item;
import com.luma.luma.Model.Loan;
import com.luma.luma.Model.Card;
import com.luma.luma.Repository.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTransactionTest {

    @InjectMocks
    private CreateTransaction createTransaction;

    @Mock
    CardRepository cardRepository;
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    IssueRepository issueRepository;
    @Mock
    ItemRepository itemRepository;
    @Mock
    LoanRepository loanRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createTransaction() {
        IssueDTO new_issue = new IssueDTO();
        new_issue.setIid("I001");
        new_issue.setEid("E001");

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
        Optional<Item> o_item = Optional.of(item1);
        when(itemRepository.findById(Mockito.anyString())).thenReturn(o_item);

        Issue issue1 = new Issue();
        issue1.setId("IS001");
        issue1.setIssueDate(new Date());
        issue1.setEid(employee1);
        issue1.setIid(item1);
        when(issueRepository.save(Mockito.any(Issue.class))).thenReturn(issue1);

        Loan loan1 = new Loan();
        loan1.setDuration(5);
        loan1.setType("Furniture");
        loan1.setId("L001");

        List<Loan> loans = new ArrayList<>();
        loans.add(loan1);
        when(loanRepository.findByType(Mockito.anyString())).thenReturn(loans);

        Card card1 = new Card();
        card1.setCid(new Date());
        card1.setEid(employee1);
        card1.setLid(loan1);
        when(cardRepository.save(Mockito.any(Card.class))).thenReturn(card1);

        int int_val = createTransaction.createTransaction(new_issue);
        assertEquals(200,int_val);
    }
}
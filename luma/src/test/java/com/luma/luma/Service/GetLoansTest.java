package com.luma.luma.Service;

import com.luma.luma.Model.Card;
import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Loan;
import com.luma.luma.Repository.CardRepository;
import com.luma.luma.Repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetLoansTest {

    @InjectMocks
    GetLoans getLoans;

    @Mock
    CardRepository cardRepository;
    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLoans() {
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

        Loan loan1 = new Loan();
        loan1.setDuration(5);
        loan1.setType("Furniture");
        loan1.setId("L001");

        Loan loan2 = new Loan();
        loan2.setDuration(5);
        loan2.setType("Furniture");
        loan2.setId("L002");

        Card card1 = new Card();
        card1.setCid(new Date());
        card1.setEid(employee1);
        card1.setLid(loan1);

        Card card2 = new Card();
        card2.setCid(new Date());
        card2.setEid(employee1);
        card2.setLid(loan2);

        List<Card> cards = new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        when(cardRepository.findByEid(Mockito.any(Employee.class))).thenReturn(cards);

        Set<Loan> loans = getLoans.getLoans(employee1.getId());
        assertThat(loans).isNotNull();
        assertThat(loans).hasSize(2);
    }
}
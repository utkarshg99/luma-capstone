package com.luma.luma.Repository;

import com.luma.luma.Model.Loan;
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
class LoanRepositoryTest {

    @Autowired
    private LoanRepository loanRepository;
    
    Loan loan1 = null;
    Loan newLoan1 = null;
    
    @BeforeEach
    void setUp() {
        loan1 = new Loan();
        loan1.setDuration(5);
        loan1.setType("Furniture");
        loan1.setId("L001");
        newLoan1 = loanRepository.save(loan1);
    }

    @AfterEach
    void tearDown() {
        loanRepository.deleteById("L001");
    }

    @Test
    public void addLoan(){
        assertThat(newLoan1).isNotNull();
        assertThat(loan1.getId()).isEqualTo(newLoan1.getId());
    }

    @Test
    public void getAllLoans(){
        List<Loan> loanList = loanRepository.findAll();
        assertThat(loanList).isNotNull();
        assertThat(loanList).anyMatch(c -> c.getType().equals(loan1.getType()));
    }

    @Test
    public void findLoanByID(){
        Loan ln1 = loanRepository.findById(loan1.getId()).orElse(null);
        Loan ln2 = loanRepository.findById("L002").orElse(null);
        assertThat(ln1).isNotNull();
        assertThat(ln2).isNull();
        assertThat(ln1.getType()).isEqualTo(newLoan1.getType());
    }

    @Test
    public void deleteByIdTest(){
        Loan ln1 = loanRepository.findById(loan1.getId()).orElse(null);
        loanRepository.deleteById(ln1.getId());
        List<Loan> loanList = loanRepository.findAll();
        assertFalse(loanList.contains(ln1));
//        assertThat(loanList).anyMatch(c -> c.getId().equals(loan1.getId())).;
//        assertThat(loanList).isNull();
    }
    @Test
    void findByType() {
        List<Loan> loanList1 = loanRepository.findByType("Furniture");
        assertThat(loanList1).isNotNull();
        assertThat(loanList1).anyMatch(c -> c.getId().equals(loan1.getId()));
    }
}
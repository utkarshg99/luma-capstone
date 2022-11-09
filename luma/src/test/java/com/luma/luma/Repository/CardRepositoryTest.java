//package com.luma.luma.Repository;
//
//import com.luma.luma.Model.Card;
//import com.luma.luma.Model.Employee;
//import com.luma.luma.Model.card;
//import com.luma.luma.Model.Loan;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Date;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//class CardRepositoryTest {
//
//    @Autowired
//    private CardRepository cardRepository;
//
//    Card card1 = null;
//    Card newCard1 = null;
//
//    Employee employee1 = null;
//    Loan loan1 = null;
//
//    @BeforeEach
//    void setUp() {
//        employee1 = new Employee();
//        employee1.setId("E001");
//        employee1.setDoj(new Date());
//        employee1.setDob(new Date());
//        employee1.setGender('M');
//        employee1.setName("Rahul");
//        employee1.setDepartment("Sales");
//        employee1.setDesignation("Associate");
//
//        loan1 = new Loan();
//        loan1.setDuration(5);
//        loan1.setType("Furniture");
//        loan1.setId("L001");
//
//        card1.setCid(new Date());
//        card1.setEid(employee1);
//        card1.setLid(loan1);
//        cardRepository.save(card1);
//    }
//
//    @AfterEach
//    void tearDown() {
//        cardRepository.deleteAll();
//    }
//
//    @Test
//    public void addCard(){
//        assertThat(newCard1).isNotNull();
//        assertThat(card1.getEid()).isEqualTo(newCard1.getEid());
//    }
//
//    @Test
//    public void getAllCards(){
//        List<Card> cardList = cardRepository.findAll();
//        assertThat(cardList).isNotNull();
//        assertThat(cardList).anyMatch(c -> c.getCid().equals(card1.getCid()));
//        assertThat(cardList).hasSize(1);
//    }
//
//
//    @Test
//    void findByEid() {
//        List<Card> cardList = cardRepository.findByEid(employee1);
//        assertThat(cardList).isNotNull();
//        assertThat(cardList).hasSize(1);
//    }
//}
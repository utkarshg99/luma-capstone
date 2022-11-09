package com.luma.luma.Repository;

import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Issue;
import com.luma.luma.Model.Item;
import com.luma.luma.Model.Issue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.setMaxStackTraceElementsDisplayed;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IssueRepositoryTest {

    @Autowired
    private IssueRepository issueRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ItemRepository itemRepository;

    Issue issue1 = null;
    Issue newIssue1 = null;
    Employee employee1 = null;
    Item item1 = null;

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
        employeeRepository.save(employee1);


        item1 = new Item();
        item1.setId("I001");
        item1.setCategory("Furniture");
        item1.setStatus('Y');
        item1.setDescription("medium brown chair");
        item1.setMake("Wood");
        item1.setValuation(1000);
        itemRepository.save(item1);

        issue1 = new Issue();
        issue1.setId("IS001");
        issue1.setIssueDate(new Date());
        issue1.setEid(employee1);
        issue1.setIid(item1);
        newIssue1 = issueRepository.save(issue1);
    }

    @AfterEach
    void tearDown() {
        issueRepository.deleteById("IS001");
        itemRepository.deleteById("I001");
        employeeRepository.deleteById("E001");
    }

    @Test
    public void addIssue(){
        assertThat(newIssue1).isNotNull();
        assertThat(issue1.getId()).isEqualTo(newIssue1.getId());
    }

    @Test
    public void getAllIssues(){
        List<Issue> issueList = issueRepository.findAll();
        assertThat(issueList).isNotNull();
        assertThat(issueList).anyMatch(c -> c.getIssueDate().equals(issue1.getIssueDate()));
        assertThat(issueList).hasSize(1);
    }

    @Test
    public void findIssueByID(){
        Issue is1 = issueRepository.findById(issue1.getId()).orElse(null);
        Issue is2 = issueRepository.findById("IS002").orElse(null);
        assertThat(is1).isNotNull();
        assertThat(is2).isNull();
        assertThat(is1.getIssueDate()).isEqualTo(newIssue1.getIssueDate());
    }

    @Test
    public void deleteByIdTest(){
        Issue Is1 = issueRepository.findById(issue1.getId()).orElse(null);
        issueRepository.deleteById(Is1.getId());
        List<Issue> issueList = issueRepository.findAll();
        assertFalse(issueList.contains(Is1));
    }

    @Test
    void findByEid() {
        List<Issue> issueList1 = issueRepository.findByEid(employee1);
        assertThat(issueList1).isNotNull();
    }
}
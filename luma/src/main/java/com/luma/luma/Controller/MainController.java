package com.luma.luma.Controller;

import com.luma.luma.Controller.DTO.*;
import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import com.luma.luma.Service.CreateTransaction;
import com.luma.luma.Service.GetItems;
import com.luma.luma.Service.GetLoans;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {

    final CardRepository cardRepository;
    final EmployeeRepository employeeRepository;
    final IssueRepository issueRepository;
    final ItemRepository itemRepository;
    final LoanRepository loanRepository;

    final CreateTransaction createTransaction;
    final GetLoans getLoans;
    final GetItems getItems;

    @PostMapping(path = "/add/employee")
    public @ResponseBody String addNewEmployee (@RequestBody EmployeeDTO new_employee){
        Employee emp = new Employee();
        emp.setName(new_employee.getName());
        emp.setDesignation(new_employee.getDesignation());
        emp.setDepartment(new_employee.getDepartment());
        emp.setDoj(new_employee.getDoj());
        emp.setDob(new_employee.getDob());
        emp.setGender(new_employee.getGender());
        employeeRepository.save(emp);
        return "Employee Saved";
    }

    @PostMapping(path = "/add/item")
    public @ResponseBody String addNewItem (@RequestBody ItemDTO new_item){
        Item item = new Item();
        item.setMake(new_item.getMake());
        item.setCategory(new_item.getCategory());
        item.setStatus(new_item.getStatus());
        item.setDescription(new_item.getDescription());
        item.setValuation(new_item.getValuation());
        itemRepository.save(item);
        return "Item Saved";
    }

    @PostMapping(path = "/add/loan")
    public @ResponseBody String addNewLoan (@RequestBody LoanDTO new_loan){
        Loan loan = new Loan();
        loan.setType(new_loan.getType());
        loan.setDuration(new_loan.getDuration());
        loanRepository.save(loan);
        return "Loan Saved";
    }

    @PostMapping(path = "/card_issue")
    public @ResponseBody ResponseEntity<String> addNewIssue (@RequestBody IssueDTO new_issue){
        int val = createTransaction.createTransaction(new_issue);
        int status = (val == 200) ? 200 : 404;
        String body = "";
        switch(val){
            case 1: body = "Employee not found."; break;
            case 2: body = "Item not found."; break;
            case 200: body = "Issue and Card Saved."; break;
        }
        return ResponseEntity.status(status).body(body);
    }

    @PostMapping(path="/loans")
    public @ResponseBody Set<Loan> getLoansByEmployeeId(@RequestBody LoanEmployeeDTO eid) {
        Set<Loan> loans = getLoans.getLoans(eid.getEid());
        return loans;
    }

    @PostMapping(path="/items")
    public @ResponseBody List<Item> getItemsByEmployeeId(@RequestBody ItemEmployeeDTO eid) {
        List<Item> items = getItems.getItems(eid.getEid());
        return items;
    }

    @GetMapping(path="/all/card")
    public @ResponseBody Iterable<Card> getAllCards(){
        return cardRepository.findAll();
    }

    @GetMapping(path="/all/employee")
    public @ResponseBody Iterable<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping(path="/all/issue")
    public @ResponseBody Iterable<Issue> getAllIssues(){
        return issueRepository.findAll();
    }

    @GetMapping(path="/all/item")
    public @ResponseBody Iterable<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @GetMapping(path="/all/loan")
    public @ResponseBody Iterable<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

}

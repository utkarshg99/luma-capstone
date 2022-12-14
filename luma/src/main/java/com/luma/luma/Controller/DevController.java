package com.luma.luma.Controller;

import com.luma.luma.Controller.DTO.*;
import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import com.luma.luma.Service.CreateTransaction;
import com.luma.luma.Service.GetIssueItems;
import com.luma.luma.Service.GetLoans;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@ConditionalOnProperty("dev-mode")
public class DevController {

    final CardRepository cardRepository;
    final EmployeeRepository employeeRepository;
    final IssueRepository issueRepository;
    final ItemRepository itemRepository;
    final LoanRepository loanRepository;
    final UserRepository userRepository;

    final CreateTransaction createTransaction;
    final GetLoans getLoans;
    final GetIssueItems getIssueItems;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(path = "/add/employee")
    public @ResponseBody String addNewEmployee (@Valid @RequestBody EmployeeDTO new_employee){
        Employee emp = new Employee();
        emp.setName(new_employee.getName());
        emp.setDesignation(new_employee.getDesignation());
        emp.setDepartment(new_employee.getDepartment());
        emp.setDoj(new_employee.getDoj());
        emp.setDob(new_employee.getDob());
        emp.setGender(new_employee.getGender());
        employeeRepository.save(emp);

        User user = new User();
        user.setEid(emp);
        user.setPassword(passwordEncoder.encode(new_employee.getPassword()));
        userRepository.save(user);

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

    @GetMapping(path="/all/user")
    public @ResponseBody Iterable<User> getAllUsers(){ return userRepository.findAll(); }

}

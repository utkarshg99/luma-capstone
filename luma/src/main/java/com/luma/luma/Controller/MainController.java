package com.luma.luma.Controller;

import com.luma.luma.Controller.DTO.*;
import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import com.luma.luma.Service.CreateTransaction;
import com.luma.luma.Service.GetIssueItems;
import com.luma.luma.Service.GetLoans;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "*")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {

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
    public @ResponseBody List<ItemIssueDTO> getItemsByEmployeeId(@RequestBody ItemEmployeeDTO eid) {
        List<ItemIssueDTO> items = getIssueItems.getItems(eid.getEid());
        return items;
    }

    @GetMapping(path="/perform_login")
    public @ResponseBody ResponseEntity<String> performLogin (){
        return ResponseEntity.status(200).body("");
    }

    @GetMapping(path="/all/item")
    public @ResponseBody Iterable<Item> getAllItems(){
        return itemRepository.findAll();
    }

    @GetMapping(path="/all/loan")
    public @ResponseBody Iterable<Loan> getAllLoans(){
        return loanRepository.findAll();
    }

    @GetMapping(path="/")
    public String getBase(){ return "index.html"; }

}

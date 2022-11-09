package com.luma.luma.Service;

import com.luma.luma.Controller.DTO.IssueDTO;
import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import com.luma.luma.ResourceNotFoundException;
import com.luma.luma.Utility.CardCreate;
import com.luma.luma.Utility.IssueCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateTransaction {

    final CardRepository cardRepository;
    final EmployeeRepository employeeRepository;
    final IssueRepository issueRepository;
    final ItemRepository itemRepository;
    final LoanRepository loanRepository;

    public int createTransaction(IssueDTO new_issue) {
        Optional<Employee> o_emp = Optional.ofNullable(employeeRepository.findById(new_issue.getEid())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", new_issue.getEid())));
        if(o_emp.isEmpty()) return 1;
        Employee emp = o_emp.get();

        Optional<Item> o_itm = itemRepository.findById(new_issue.getIid());
        if(o_itm.isEmpty()) return 2;
        Item item = o_itm.get();

        List<Loan> loans = loanRepository.findByType(item.getCategory());
        Loan loan = loans.get(0);

        issueRepository.save(IssueCreate.issueCreate(emp, item));
        cardRepository.save(CardCreate.cardCreate(emp, loan));

        return 200;
    }
}

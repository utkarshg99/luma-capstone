package com.luma.luma.Service;

import com.luma.luma.Controller.DTO.IssueDTO;
import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import com.luma.luma.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
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

        Issue issue = new Issue();
        issue.setEid(emp);
        issue.setIid(item);
        issue.setIssueDate(Date.from(Instant.now()));
        issueRepository.save(issue);

        Card card = new Card();
        CardId cardid = new CardId();
        cardid.setEid(emp.getId());
        cardid.setLid(loan.getId());
        card.setCardid(cardid);
        card.setEid(emp);
        card.setLid(loan);
        card.setCid(Date.from(Instant.now()));
        cardRepository.save(card);
        return 200;
    }
}

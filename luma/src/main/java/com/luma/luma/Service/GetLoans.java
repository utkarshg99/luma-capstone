package com.luma.luma.Service;

import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetLoans {

    final CardRepository cardRepository;
    final EmployeeRepository employeeRepository;

    public Set<Loan> getLoans(String eid) {
        Optional<Employee> o_emp = employeeRepository.findById(eid);
        if(o_emp.isEmpty()) { return new HashSet<>(); }
        Employee emp = o_emp.get();

        List<Card> cards = cardRepository.findByEid(emp);
        Set<Loan> loans = new HashSet<>();
        for(Card card: cards){
            loans.add(card.getLid());
        }
        return loans;
    }
}

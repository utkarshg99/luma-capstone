package com.luma.luma.Service;

import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetItems {

    final EmployeeRepository employeeRepository;
    final IssueRepository issueRepository;

    public List<Item> getItems(String eid) {
        Optional<Employee> o_emp = employeeRepository.findById(eid);
        if(o_emp.isEmpty()) { return new ArrayList<>(); }
        Employee emp = o_emp.get();

        List<Issue> issues = issueRepository.findByEid(emp);
        List<Item> items = new ArrayList<>();
        for(Issue issue: issues){
            items.add(issue.getIid());
        }
        return items;
    }
}

package com.luma.luma.Service;

import com.luma.luma.Controller.DTO.ItemIssueDTO;
import com.luma.luma.Model.*;
import com.luma.luma.Repository.*;
import com.luma.luma.ResourceNotFoundException;
import com.luma.luma.Utility.IssueToItemIssueDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GetIssueItems {

    final EmployeeRepository employeeRepository;
    final IssueRepository issueRepository;

    public List<ItemIssueDTO> getItems(String eid) {
        Optional<Employee> o_emp = Optional.ofNullable(employeeRepository.findById(eid)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", eid)));
        if(o_emp.isEmpty()) { return new ArrayList<>(); }
        Employee emp = o_emp.get();

        List<Issue> issues = issueRepository.findByEid(emp);
        List<ItemIssueDTO> items = new ArrayList<>();
        for(Issue issue: issues){
            items.add(IssueToItemIssueDTO.issueToItemIssueDTO(issue));
        }
        return items;
    }
}

package com.luma.luma.Utility;

import com.luma.luma.Model.Employee;
import com.luma.luma.Model.Issue;
import com.luma.luma.Model.Item;

import java.time.Instant;
import java.util.Date;

public class IssueCreate {
    public static Issue issueCreate(Employee emp, Item item){
        Issue issue = new Issue();
        issue.setEid(emp);
        issue.setIid(item);
        issue.setIssueDate(Date.from(Instant.now()));
        return issue;
    }
}

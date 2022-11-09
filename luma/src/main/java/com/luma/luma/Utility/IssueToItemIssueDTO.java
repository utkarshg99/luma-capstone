package com.luma.luma.Utility;

import com.luma.luma.Controller.DTO.ItemIssueDTO;
import com.luma.luma.Model.Issue;

public class IssueToItemIssueDTO {
    public static ItemIssueDTO issueToItemIssueDTO(Issue issue){
        ItemIssueDTO item_issue = new ItemIssueDTO();
        item_issue.setIssue_id(issue.getId());
        item_issue.setMake(issue.getIid().getMake());
        item_issue.setCategory(issue.getIid().getCategory());
        item_issue.setStatus(issue.getIid().getStatus());
        item_issue.setDescription(issue.getIid().getDescription());
        item_issue.setValuation(issue.getIid().getValuation());
        return item_issue;
    }
}

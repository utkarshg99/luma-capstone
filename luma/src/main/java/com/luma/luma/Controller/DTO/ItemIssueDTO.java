package com.luma.luma.Controller.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemIssueDTO {
    private String description;
    private char status;
    private String make;
    private String category;
    private int valuation;
    private String issue_id;
}

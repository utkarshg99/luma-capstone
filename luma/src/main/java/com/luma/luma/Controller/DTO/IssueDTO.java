package com.luma.luma.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IssueDTO {
    @NonNull
    private String id;
    private String e_id;
    private String i_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date issue_date;
}

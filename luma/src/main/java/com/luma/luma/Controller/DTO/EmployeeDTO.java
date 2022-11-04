package com.luma.luma.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NonNull
    private String id;
    private String name;
    private String designation;
    private String department;
    private char gender;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dob;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date doj;
}

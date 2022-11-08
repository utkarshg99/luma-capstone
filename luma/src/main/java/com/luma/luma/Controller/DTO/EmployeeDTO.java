package com.luma.luma.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    @NotEmpty(message = "provide a name")
    private String name;
    @NotEmpty(message = "designation should be provided")
    private String designation;
    @NotEmpty(message = "department must be provided")
    private String department;
    @NotEmpty(message = "must not be empty")
    private String password;
    private char gender;
    @NotEmpty(message = "must not be empty")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dob;
    @NotEmpty(message = "must not be empty")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date doj;
}

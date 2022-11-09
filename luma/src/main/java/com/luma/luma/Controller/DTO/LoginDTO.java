package com.luma.luma.Controller.DTO;

import lombok.*;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}

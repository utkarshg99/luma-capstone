package com.luma.luma.Controller.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    @NonNull
    private String id;
    private String type;
    private int duration;
}

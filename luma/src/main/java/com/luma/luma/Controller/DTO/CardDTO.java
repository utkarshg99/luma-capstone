package com.luma.luma.Controller.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
    private String e_id;
    private String l_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date cid;
}

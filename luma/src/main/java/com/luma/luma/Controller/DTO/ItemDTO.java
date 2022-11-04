package com.luma.luma.Controller.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    private String description;
    private char status;
    private String make;
    private String category;
    private int valuation;
}

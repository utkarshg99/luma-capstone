package com.luma.luma.Controller.DTO;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
    @NonNull
    private String id;
    private String description;
    private char status;
    private String make;
    private String category;
    private int valuation;
}

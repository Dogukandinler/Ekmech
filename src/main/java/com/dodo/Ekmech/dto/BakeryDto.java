package com.dodo.Ekmech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BakeryDto {
    private Long id;
    private String email;
    private String name;
    private String password;
    private List<ServicesDto> services;
    private List<ExpenseDto> expenses;
    private List<ProductDto> products;
}
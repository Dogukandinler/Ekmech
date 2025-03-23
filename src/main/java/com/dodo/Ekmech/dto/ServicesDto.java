package com.dodo.Ekmech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDto {
    private Long id;
    private String customerName;
    private BigDecimal balance;
    private Integer returnedBreads;
    private Integer service1Quantity;
    private Integer service2Quantity;
    private Integer service3Quantity;
    private Integer service4Quantity;
    private Integer service5Quantity;
    private BigDecimal payment;
    private LocalDate serviceDate;
}
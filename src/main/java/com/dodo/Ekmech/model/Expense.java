package com.dodo.Ekmech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String description;
    private BigDecimal amount;  

    @ManyToOne
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;

    // İhtiyaca göre gider tipi alanı eklenebilir.
}
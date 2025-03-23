package com.dodo.Ekmech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName; // Bakkal/marketin adı
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;

    private Integer returnedBreads ; // Geri verilen ekmek sayısı
    private Integer service1Quantity;
    private Integer service2Quantity;
    private Integer service3Quantity;
    private Integer service4Quantity;
    private Integer service5Quantity;

    private BigDecimal payment; // Toplam ödeme tutarı
    private LocalDate serviceDate; // Servis tarihi
}
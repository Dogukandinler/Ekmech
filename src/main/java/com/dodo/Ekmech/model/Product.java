package com.dodo.Ekmech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
    private int weight ;

    @ManyToOne
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;

    // Opsiyonel: Açıklama, stok bilgisi vb.
}
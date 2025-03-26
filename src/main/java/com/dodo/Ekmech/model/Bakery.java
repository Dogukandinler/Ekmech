package com.dodo.Ekmech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bakeries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bakery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private String name;
    @OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Services> services = new ArrayList<>();
    @OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Expense> expenses = new ArrayList<>();
    @OneToMany(mappedBy = "bakery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

}

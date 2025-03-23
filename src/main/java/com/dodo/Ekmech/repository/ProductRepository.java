package com.dodo.Ekmech.repository;

import com.dodo.Ekmech.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Belirli bir fırına ait ürünleri getir
    List<Product> findByBakeryId(Long bakeryId);
}
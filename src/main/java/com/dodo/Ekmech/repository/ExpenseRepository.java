package com.dodo.Ekmech.repository;

import com.dodo.Ekmech.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByBakeryId(Long bakeryId);

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
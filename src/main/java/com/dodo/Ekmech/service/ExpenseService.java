package com.dodo.Ekmech.service;

import com.dodo.Ekmech.dto.ExpenseDto;
import com.dodo.Ekmech.model.Expense;
import com.dodo.Ekmech.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<ExpenseDto> getAllExpenses() {
        return expenseRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ExpenseDto getExpenseById(Long id) {
        return expenseRepository.findById(id).map(this::convertToDto).orElseThrow(() -> new RuntimeException("Expense not found"));
    }

    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense(null, expenseDto.getDate(), expenseDto.getDescription(), expenseDto.getAmount(), null);
        return convertToDto(expenseRepository.save(expense));
    }

    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Expense not found"));
        expense.setDate(expenseDto.getDate());
        expense.setDescription(expenseDto.getDescription());
        expense.setAmount(expenseDto.getAmount());
        return convertToDto(expenseRepository.save(expense));
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    private ExpenseDto convertToDto(Expense expense) {
        return new ExpenseDto(expense.getId(), expense.getDate(), expense.getDescription(), expense.getAmount());
    }
}

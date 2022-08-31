package com.aamir.productservice.service;

import com.aamir.productservice.model.Expense;
import com.aamir.productservice.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ExpenseService {

    private final ExpenseRepository expenseRepository;


    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find Expense by ID %s", expense.getId())));

        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseName(expense.getExpenseName());
        expenseRepository.save(savedExpense);

    }

    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name)
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot find Expense by ID %s", name)));
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }

}

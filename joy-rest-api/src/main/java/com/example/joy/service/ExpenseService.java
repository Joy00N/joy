package com.example.joy.service;

import com.example.joy.model.Expense;

import java.util.List;

public interface ExpenseService {
    List<Expense> findAll();
    List<Expense> findByMonthAndYear(String month, int year);
    List<Expense> findByYear(int year);
    void saveOrUpdateExpense(Expense expense);
    void deleteExpense(String id);
}

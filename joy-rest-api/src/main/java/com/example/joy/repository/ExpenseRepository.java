package com.example.joy.repository;

import com.example.joy.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findByMonthAndYear(String month, int year);
    List<Expense> findByYear(int year);
}

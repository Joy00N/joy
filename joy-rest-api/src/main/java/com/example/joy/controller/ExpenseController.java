package com.example.joy.controller;

import com.example.joy.model.Expense;
import com.example.joy.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/expense")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Expense> result = expenseService.findAll();
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity<?> getByMonthYear(@PathVariable("year") int year, @PathVariable("month") String month){
        List<Expense> result = new ArrayList<>();
        if("All".equals(month)){
            result.addAll(expenseService.findAll());
        }else {
            result.addAll(expenseService.findByMonthAndYear(month, year));
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addorUpdateExpense(@RequestBody Expense expense){
        expenseService.saveOrUpdateExpense(expense);
        return new ResponseEntity("Expense added Successfully", HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteExpense(@RequestParam("id") String id){
        expenseService.deleteExpense(id);
    }
}

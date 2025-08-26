package com.michal.demo.kid.controller;

import com.michal.demo.kid.entity.Transaction;
import com.michal.demo.kid.repository.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kids/requests")
public class TransactionController {
    private final TransactionRepository repo;

    public TransactionController(TransactionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Transaction> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return repo.save(transaction);
    }
}


package com.michal.demo.kid.controller;

import com.michal.demo.kid.entity.Transaction;
import com.michal.demo.kid.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<TransactionRequest> getAll() {
        return transactionService.findAll()
                .stream()
                .map(tx -> new TransactionRequest(
                        tx.getId(),
                        tx.getKid().getId(),
                        tx.getParent().getId(),
                        tx.getRTransactionType(),
                        tx.getPhoneNumber(),
                        tx.getSum(),
                        tx.getLink(),
                        tx.getMessage(),
                        tx.getStatus(),
                        tx.getReason()
                ))
                .toList();
    }

    @GetMapping("/{id}")
    public List<TransactionRequest> getTransactionsByKid(@PathVariable Long id) {
        return transactionService.findAllByKidId(id)
                .stream()
                .map(tx -> new TransactionRequest(
                        tx.getId(),
                        tx.getKid().getId(),
                        tx.getParent().getId(),
                        tx.getRTransactionType(),
                        tx.getPhoneNumber(),
                        tx.getSum(),
                        tx.getLink(),
                        tx.getMessage(),
                        tx.getStatus(),
                        tx.getReason()
                ))
                .toList();
    }

    @PostMapping
    public Transaction create(@Valid @RequestBody TransactionRequest dto) {

        return transactionService.createTransaction(dto);
    }
}
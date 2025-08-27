package com.michal.demo.controller;

import com.michal.demo.entity.Transaction;
import com.michal.demo.repository.KidRepository;
import com.michal.demo.repository.ParentRepository;
import com.michal.demo.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final KidRepository kidRepository;
    private final ParentRepository parentRepository;

    public TransactionController(TransactionService transactionService,
                                 KidRepository kidRepository,
                                 ParentRepository parentRepository) {
        this.transactionService = transactionService;
         this.kidRepository = kidRepository;
        this.parentRepository = parentRepository;
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
    public List<TransactionRequest> getTransactionsByKidId(@PathVariable Long kidId) {
        return transactionService.findAllByKidId(kidId)
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
        var kid = kidRepository.findById(dto.getKidId())
                .orElseThrow(() -> new IllegalArgumentException("Kid not found"));

        var parent = parentRepository.findById(dto.getParentId())
                .orElseThrow(() -> new IllegalArgumentException("Parent not found"));

        Transaction tx = new Transaction();
        tx.setKid(kid);
        tx.setParent(parent);
        tx.setSum(dto.getSum());
        tx.setMessage(dto.getMessage());
        tx.setTransactionType(dto.getTransactionType());
        tx.setStatus(Transaction.TransactionStatus.ACCEPTED);
        tx.setReason(dto.getReason());
        tx.setLink(dto.getLink());
        tx.setPhoneNumber(dto.getPhoneNumber());

        return transactionService.createTransaction(tx);
    }
}
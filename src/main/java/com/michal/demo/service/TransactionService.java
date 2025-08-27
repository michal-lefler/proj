package com.michal.demo.service;

import com.michal.demo.entity.Transaction;
import com.michal.demo.repository.KidRepository;
import com.michal.demo.repository.ParentRepository;
import com.michal.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              KidRepository kidRepository,
                              ParentRepository parentRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // New: find all transactions
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    // New: find all transactions by kidId
    public List<Transaction> findAllByKidId(Long kidId) {
        return transactionRepository.findByKidId(kidId);
    }
}

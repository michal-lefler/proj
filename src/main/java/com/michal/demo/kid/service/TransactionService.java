package com.michal.demo.kid.service;

import com.michal.demo.kid.controller.TransactionRequest;
import com.michal.demo.kid.entity.Transaction;
import com.michal.demo.kid.repository.KidRepository;
import com.michal.demo.kid.repository.ParentRepository;
import com.michal.demo.kid.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final KidRepository kidRepository;
    private final ParentRepository parentRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              KidRepository kidRepository,
                              ParentRepository parentRepository) {
        this.transactionRepository = transactionRepository;
        this.kidRepository = kidRepository;
        this.parentRepository = parentRepository;
    }

    public Transaction createTransaction(TransactionRequest dto) {
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

        return transactionRepository.save(tx);
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

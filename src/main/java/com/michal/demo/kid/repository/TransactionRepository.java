package com.michal.demo.kid.repository;

import com.michal.demo.kid.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByKidId(Long kidId);
}

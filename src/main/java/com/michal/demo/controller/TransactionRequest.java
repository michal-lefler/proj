package com.michal.demo.controller;

import com.michal.demo.entity.Transaction;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public class TransactionRequest {
    private Long id;

    private Long kidId;
    private Long parentId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Transaction.TransactionType transactionType;

    private String phoneNumber;
    private Double sum;
    private String link;
    private String message;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Transaction.TransactionStatus status;

    private String reason;

    public TransactionRequest(Long id, Long kidId, Long parentId, Transaction.TransactionType transactionType, String phoneNumber, Double sum, String link, String message, Transaction.TransactionStatus status, String reason) {
        this.id = id;
        this.kidId = kidId;
        this.parentId = parentId;
        this.transactionType = transactionType;
        this.phoneNumber = phoneNumber;
        this.sum = sum;
        this.link = link;
        this.message = message;
        this.status = status;
        this.reason = reason;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKidId() {
        return kidId;
    }

    public void setKidId(Long kidId) {
        this.kidId = kidId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Transaction.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Transaction.TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Transaction.TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(Transaction.TransactionStatus status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

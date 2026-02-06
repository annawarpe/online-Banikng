package com.bank.app.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "account_no")
    private Long accountNo;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "txn_date")
    private Timestamp txnDate;

    @Column(name = "date")
    private LocalDateTime date;

    // ===== GETTERS =====

    public Long getTransactionId() {
        return transactionId;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public Double getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public Timestamp getTxnDate() {
        return txnDate;
    }

    public LocalDateTime getDate() {
        return date;
    }

    // ===== SETTERS =====

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setTxnDate(Timestamp txnDate) {
        this.txnDate = txnDate;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

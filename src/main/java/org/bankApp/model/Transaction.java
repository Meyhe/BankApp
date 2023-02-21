package org.bankApp.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TRANSACTION")
    private Long transactionId;

    @Column(name = "ID_ACCOUNT")
    private Long accountId;

    @Column(name = "DATE_TRANSACTION")
    private Date transactionDateTime;

    @Column(name = "STATUS_TRANSACTION")
    private String transactionStatus;

    @Column(name = "TYPE_TRANSACTION")
    private String transactionType;

    @Column(name = "AMOUNT_TRANSACTION")
    private BigDecimal transactionAmount;

    public Transaction(Long transactionId, Long accountId, Date transactionDateTime, String transactionStatus, String transactionType, BigDecimal transactionAmount) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.transactionDateTime = transactionDateTime;
        this.transactionStatus = transactionStatus;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    public Transaction() {
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}

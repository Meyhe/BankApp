package org.bankApp.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_ACCOUNT")
    private Long accountId;

    @Column(name="STATUS_ACCOUNT")
    private String accountStatus;

    @Column(name = "TYPE_ACCOUNT")
    private String accountType;

    @Column(name = "BALANCE_ACCOUNT")
    private BigDecimal accountBalance;

    public Account(Long accountId, String accountStatus, String accountType, BigDecimal accountBalance) {
        this.accountId = accountId;
        this.accountStatus = accountStatus;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    public Account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }
}

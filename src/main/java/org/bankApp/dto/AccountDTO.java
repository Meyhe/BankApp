package org.bankApp.dto;


import org.springframework.hateoas.RepresentationModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountDTO extends RepresentationModel<AccountDTO> {

    private Long accountId;
    private String accountStatus;
    private String accountType;
    private BigDecimal accountBalance;

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

package org.bankApp.service;

import org.bankApp.exception.MyEntityNotFoundException;
import org.bankApp.model.Account;
import org.bankApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account getAccount(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new MyEntityNotFoundException(id));
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account newAccount(Account account){
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account, Long id){
        Account updateAccount = getAccount(id);

        updateAccount.setAccountStatus(account.getAccountStatus());
        updateAccount.setAccountType(account.getAccountType());
        updateAccount.setAccountBalance(account.getAccountBalance());

        return accountRepository.save(updateAccount);
    }

    public void deleteAccount(Long id){
        accountRepository.deleteById(id);
    }
}

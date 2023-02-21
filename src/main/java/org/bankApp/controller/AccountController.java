package org.bankApp.controller;

import org.bankApp.assembler.AccountAssembler;
import org.bankApp.dto.AccountDTO;
import org.bankApp.mapper.AccountMapper;
import org.bankApp.model.Account;
import org.bankApp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountAssembler accountAssembler;
    private final AccountMapper accountMapper;

    @Autowired
    public AccountController(AccountService accountService, AccountAssembler accountAssembler, AccountMapper accountMapper) {
        this.accountService = accountService;
        this.accountAssembler = accountAssembler;
        this.accountMapper = accountMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO getAccount(@PathVariable Long id){
        Account result = accountService.getAccount(id);
        return accountMapper.accountToAccountDTO(result);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<AccountDTO> getAllAccounts(Long accountId){
        List<Account> accountList = accountService.getAllAccounts();
        return accountAssembler.toCollectionModel(accountList);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountDTO newAccount (@RequestBody Account account){
        Account newAccount = accountService.newAccount(account);
        return accountMapper.accountToAccountDTO(newAccount);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO updateAccount(@RequestBody Account account, @PathVariable Long id){
        Account updateAccount = accountService.updateAccount(account, id);
        return accountMapper.accountToAccountDTO(updateAccount);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
    }
}

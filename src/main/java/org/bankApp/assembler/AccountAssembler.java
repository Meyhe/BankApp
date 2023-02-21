package org.bankApp.assembler;

import org.bankApp.controller.AccountController;
import org.bankApp.dto.AccountDTO;
import org.bankApp.mapper.AccountMapper;
import org.bankApp.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class AccountAssembler implements RepresentationModelAssembler<Account, AccountDTO> {

    private AccountMapper accountMapper;

    @Autowired
    public AccountAssembler(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountDTO toModel(Account account){

        AccountDTO accountDTO = accountMapper.accountToAccountDTO(account);

        accountDTO.add(linkTo(methodOn(AccountController.class)
                .getAllAccounts(account.getAccountId()))
                .withRel("ACCOUNTS")
                .withType("GET"));

        return accountDTO;
    }

    @Override
    public CollectionModel<AccountDTO> toCollectionModel(Iterable<? extends Account> accountList) {
        CollectionModel<AccountDTO> accountDTOCollectionModel = RepresentationModelAssembler.super.toCollectionModel(accountList);
        return accountDTOCollectionModel;
    }
}

package org.bankApp.service;

import org.bankApp.exception.MyEntityNotFoundException;
import org.bankApp.model.Transaction;
import org.bankApp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction getTransaction(Long id){
        return transactionRepository.findById(id).orElseThrow(()-> new MyEntityNotFoundException(id));
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transaction newTransaction(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    //по сути, изменяться может только статус транзакции - всё ОК или нет
    public Transaction updateTransaction(Transaction transaction, Long id){
        Transaction updateTransaction = getTransaction(id);

        updateTransaction.setTransactionStatus(transaction.getTransactionStatus());

        return updateTransaction;
    }

    //а можно ли удалять транзкции? Только отмена...
    public void deleteTransaction(Long id){
        transactionRepository.deleteById(id);
    }
}

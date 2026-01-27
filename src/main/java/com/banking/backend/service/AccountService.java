package com.banking.backend.service;

import com.banking.backend.model.entity.Account;
import com.banking.backend.model.entity.Transaction;

import java.util.List;


public interface AccountService {

    Account createAccount(Long userId);

    Account getAccount(Long accountNumber);

    Account deposit(Long accountNumber, Double amount);

    Account withdraw(Long accountNumber, Double amount);

    List<Transaction> getTransactions(Long accountNumber);

    void transferMoney(Long fromAccount, Long toAccountNumber, Double amount);
}

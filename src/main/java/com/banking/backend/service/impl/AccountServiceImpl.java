package com.banking.backend.service.impl;

import com.banking.backend.model.entity.Account;

import com.banking.backend.model.entity.Transaction;
import com.banking.backend.model.entity.TransactionType;
import com.banking.backend.model.entity.User;
import com.banking.backend.repository.AccountRepository;

import com.banking.backend.repository.TransactionRepository;
import com.banking.backend.repository.UserRepository;
import com.banking.backend.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

//@Service
//public class AccountServiceImpl implements AccountService {
//
//    private final AccountRepository accountRepository;
//    private final UserRepository userRepository;
//    private final TransactionRepository transactionRepository;
//
//
//    //  STEP 5 IS HERE (CONSTRUCTOR INJECTION)
//    public AccountServiceImpl(
//            AccountRepository accountRepository,
//            UserRepository userRepository,
//            TransactionRepository transactionRepository
//    ) {
//        this.accountRepository = accountRepository;
//        this.userRepository = userRepository;
//        this.transactionRepository = transactionRepository;
//    }
//
//
//    //  STEP 4 IS THIS METHOD
//    @Transactional
//    public Account deposit(Long accountNumber, Double amount) {
//
//        if (amount <= 0) {
//            throw new RuntimeException("Deposit amount must be positive");
//        }
//
//        Account account = accountRepository.findById(accountNumber)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//
//        account.setBalance(account.getBalance() + amount);
//
//        Transaction tx = new Transaction();
//        tx.setAccount(account);
//        tx.setAmount(amount);
//        tx.setType(TransactionType.DEPOSIT);
//        tx.setTimestamp(LocalDateTime.now());
//
//        transactionRepository.save(tx);
//
//        return accountRepository.save(account);
//    }
//
//    @Transactional
//    public Account withdraw(Long accountNumber, Double amount) {
//
//        if (amount <= 0) {
//            throw new RuntimeException("Withdraw amount must be positive");
//        }
//
//        Account account = accountRepository.findById(accountNumber)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//
//        if (account.getBalance() < amount) {
//            throw new RuntimeException("Insufficient balance");
//        }
//
//        account.setBalance(account.getBalance() - amount);
//
//        Transaction tx = new Transaction();
//        tx.setAccount(account);
//        tx.setAmount(amount);
//        tx.setType(TransactionType.WITHDRAW);
//        tx.setTimestamp(LocalDateTime.now());
//
//        transactionRepository.save(tx);
//
//        return accountRepository.save(account);
//    }
//    @Override
//    public List<Transaction> getTransactions(Long accountNumber) {
//        return transactionRepository.findByAccount_AccountNumber(accountNumber);
//    }
//
//
//}

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public AccountServiceImpl(
            AccountRepository accountRepository,
            UserRepository userRepository,
            TransactionRepository transactionRepository
    ) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Account createAccount(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setBalance(0.0);
        account.setUser(user);
        account.setFullName(user.getFullName());

        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long accountNumber) {
        return accountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public Account deposit(Long accountNumber, Double amount) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);

        Transaction tx = new Transaction();
        tx.setAccount(account);
        tx.setAmount(amount);
        tx.setType(TransactionType.DEPOSIT);
        tx.setTimestamp(LocalDateTime.now());

        transactionRepository.save(tx);
        return accountRepository.save(account);
    }

    @Override
    public Account withdraw(Long accountNumber, Double amount) {
        Account account = accountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        account.setBalance(account.getBalance() - amount);

        Transaction tx = new Transaction();
        tx.setAccount(account);
        tx.setAmount(amount);
        tx.setType(TransactionType.WITHDRAW);
        tx.setTimestamp(LocalDateTime.now());

        transactionRepository.save(tx);
        return accountRepository.save(account);
    }


    @Override
    public List<Transaction> getTransactions(Long accountNumber) {
        return transactionRepository
                .findByAccount_AccountNumber(accountNumber);
    }
}

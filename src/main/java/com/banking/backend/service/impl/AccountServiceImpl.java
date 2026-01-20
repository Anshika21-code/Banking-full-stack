package com.banking.backend.service.impl;

import com.banking.backend.model.entity.Account;
import com.banking.backend.model.entity.User;
import com.banking.backend.repository.AccountRepository;
import com.banking.backend.repository.UserRepository;
import com.banking.backend.service.AccountService;
import org.springframework.stereotype.Service;
//
//@Service
//public class AccountServiceImpl implements AccountService {
//
//    private final AccountRepository accountRepository;
//    private final UserRepository userRepository;
//
//    public AccountServiceImpl(AccountRepository accountRepository,
//                              UserRepository userRepository) {
//        this.accountRepository = accountRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public Account createAccount(Long userId) {
//
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        Account account = new Account();
//        account.setAccountNumber(System.currentTimeMillis());
//        account.setBalance(0.0);
//        account.setUser(user);
//
//        //  FIX — SET REQUIRED FIELD
//        account.setFullName(user.getFullName());
//        account.setEmail(user.getEmail());
//
//        return accountRepository.save(account);
//    }
//
//
//    @Override
//    public Account getAccount(Long accountNumber) {
//        return accountRepository.findById(accountNumber)
//                .orElseThrow(() -> new RuntimeException("Account not found"));
//    }
//}

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountServiceImpl(AccountRepository accountRepository,
                              UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Account createAccount(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Account account = new Account();
        account.setAccountNumber(System.currentTimeMillis());
        account.setBalance(0.0);
        account.setUser(user);   // ✅ ONLY relation

        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long accountNumber) {
        return accountRepository.findById(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }
}


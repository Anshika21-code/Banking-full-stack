package com.banking.backend.service.impl;

import com.banking.backend.model.entity.Account;

import com.banking.backend.model.entity.User;
import com.banking.backend.repository.AccountRepository;

import com.banking.backend.repository.UserRepository;
import com.banking.backend.service.AccountService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    //  STEP 5 IS HERE (CONSTRUCTOR INJECTION)
    public AccountServiceImpl(
            AccountRepository accountRepository,
            UserRepository userRepository) {

        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }


    //  STEP 4 IS THIS METHOD
    @Transactional
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
}

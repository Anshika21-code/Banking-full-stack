package com.banking.backend.controller;

import com.banking.backend.model.entity.Account;
import com.banking.backend.service.AccountService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // CREATE
    @PostMapping("/create/{userId}")
    public Account createAccount(@PathVariable Long userId) {
        return accountService.createAccount(userId);
    }

    // GET
    @GetMapping("/{accountNumber}")
    public Account getAccount(@PathVariable Long accountNumber) {
        return accountService.getAccount(accountNumber);
    }

    // DEPOSIT
    @PostMapping("/{accountNumber}/deposit")
    public Account deposit(
            @PathVariable Long accountNumber,
            @RequestParam Double amount) {

        return accountService.deposit(accountNumber, amount);
    }

    // WITHDRAW
    @PostMapping("/{accountNumber}/withdraw")
    public Account withdraw(
            @PathVariable Long accountNumber,
            @RequestParam Double amount) {

        return accountService.withdraw(accountNumber, amount);
    }
}


//package com.banking.backend.service;
//
//import com.banking.backend.model.entity.Account;
//import com.banking.backend.repository.AccountRepository;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AccountService {
//
//    private final AccountRepository accountRepository;
//
//    public AccountService(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//
//    public Account createAccount(Account account) {
//        return accountRepository.save(account);
//    }
//
//    public Account getByAccountNumber(Long accountNumber) {
//        return accountRepository.findByAccountNumber(accountNumber)
//                .orElse(null);
//    }
//}
package com.banking.backend.service;

import com.banking.backend.model.entity.Account;

public interface AccountService {

    Account createAccount(Long userId);

    Account getAccount(Long accountNumber);
}

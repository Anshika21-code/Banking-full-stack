package com.banking.backend.repository;

import com.banking.backend.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

//    Optional<Account> findByAccountNumber(Long accountNumber);

    Optional<Account> findByEmail(String email);
}


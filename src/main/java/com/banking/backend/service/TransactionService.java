package com.banking.backend.service;

import com.banking.backend.model.entity.Transaction;
import com.banking.backend.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }
}

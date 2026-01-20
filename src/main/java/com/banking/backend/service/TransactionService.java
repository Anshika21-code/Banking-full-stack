package com.banking.backend.service;

import com.banking.backend.model.entity.Transaction;
import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions(Long accountId);
}

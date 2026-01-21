package com.banking.backend.repository;

import com.banking.backend.model.entity.AccountSequence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountSequenceRepository
        extends JpaRepository<AccountSequence, Integer> {
}

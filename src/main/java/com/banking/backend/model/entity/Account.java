package com.banking.backend.model.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    private String fullName;

    private String email;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private String securityPin;

}

package com.banking.backend.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "account_sequence")
public class AccountSequence {

    // getters & setters
    @Id
    private Integer id;

    @Column(name = "last_account_number", nullable = false)
    private Long lastAccountNumber;

}

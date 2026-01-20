package com.banking.backend.model.entity;

import jakarta.persistence.*;

//@Entity
//@Table(name = "accounts")
//public class Account {
//
//    @Id
//    @Column(name = "account_number")
//    private Long accountNumber;
//
//    @Column(nullable = false)
//    private Double balance;
//
//    @Column(nullable = false)
//    private String securityPin;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    // ===== getters & setters =====
//
//    public Long getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(Long accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public Double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Double balance) {
//        this.balance = balance;
//    }
//
//    public String getSecurityPin() {
//        return securityPin;
//    }
//
//    public void setSecurityPin(String securityPin) {
//        this.securityPin = securityPin;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}



//@Entity
//@Table(name = "accounts")
//public class Account {
//
//    @Id
//    @Column(name = "account_number")
//    private Long accountNumber;
//
//    @Column(nullable = false)
//    private Double balance;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    // ===== getters & setters =====
//
//    public Long getAccountNumber() {
//        return accountNumber;
//    }
//
//    public void setAccountNumber(Long accountNumber) {
//        this.accountNumber = accountNumber;
//    }
//
//    public Double getBalance() {
//        return balance;
//    }
//
//    public void setBalance(Double balance) {
//        this.balance = balance;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//    public void setFullName(String fullName) {
//        this.user.setFullName(fullName);
//    }
//    public void setEmail(String email) {
//        this.user.setEmail(email);
//    }
//}


//@Entity
//@Table(name = "accounts")
//public class Account {
//
//    @Id
//    private Long accountNumber;
//
//    @Column(nullable = false)
//    private Double balance;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//
//    public void setAccountNumber(long l) {
//    }
//}


@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    private String fullName;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // ===== getters & setters =====

    public Long getAccountNumber() {
        return accountNumber;
    }

//    public void setAccountNumber(Long accountNumber) {
//        this.accountNumber = accountNumber;
//    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}


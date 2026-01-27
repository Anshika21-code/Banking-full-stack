//package com.banking.backend.model.dto;
//
//import lombok.Getter;
//import lombok.Setter;
//
//public class TransferRequest {
//
//    @Setter
//
//    private Long fromAccount;
//    private Long toAccount;
//    private Double amount;
//
//    public Long getFromAccount(){
//        return fromAccount;
//    }
//
//    public Long getToAccount(){
//        return toAccount;
//    }
//
//    public Double getAmount(){
//        return amount;
//    }
//
//    public void setToAccount(Long toAccount){
//        this.toAccount = toAccount;
//  }
//
//
//
//}

package com.banking.backend.model.dto;

public class TransferRequest {

    private Long toAccount;
    private Double amount;

    public Long getToAccount() {
        return toAccount;
    }

    public void setToAccount(Long toAccount) {
        this.toAccount = toAccount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}


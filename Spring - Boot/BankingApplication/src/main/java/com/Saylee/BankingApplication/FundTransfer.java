//package com.Saylee.BankingApplication;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import java.lang.String;
//@Component
//public class FundTransfer {
//    @Autowired
//    public Account account;
//
//    @Autowired
//    public Customer customer;
//
//    public double fromAccount;
//    public double toAccount;
//    public double amount;
//
//    public FundTransfer(double fromAccount,double toAccount,double amount){
//        this.fromAccount=fromAccount;
//        this.toAccount=toAccount;
//        this.amount=amount;
//    }
//
//    public void setFromAccount(double fromAccount) {
//        this.fromAccount = customer.clientId;
//    }
//
//    public void setToAccount(double toAccount) {
//        this.toAccount = customer.clientId;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public double getFromAccount() {
//        return fromAccount;
//    }
//    public double getToAccount(){
//        return toAccount;
//    }
//
//    public void transferAmount(double fromAccount, double toAccount, double amount){
//     //   if(amount>)
//    }
//}
///*import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Component;
//
//@Component
//@Scope("prototype")
//public class FundTransfer {
//
//    @Autowired
//    Account afterTransactionBalance;
//
//
//    public void transfer(double transferAmount, @Autowired
//            Customer customerAmount, String withdrawalOrDeposit) {
//        switch (withdrawalOrDeposit) {
//            case "withdraw":{ double balance = afterTransactionBalance.withdrawalAmount(transferAmount);
//                customerAmount.setBalance(balance);
//                System.out.println("After Amount withdraw " + balance);}
//                break;
//            case "deposit":
//                double balance = afterTransactionBalance.depositAmount(transferAmount);
//                customerAmount.setBalance(balance);
//                System.out.println("After Amount deposit " +balance );
//        }
//    }
//}*/
package com.Saylee.BankingApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.lang.String;

@Component
@Scope("prototype")
public class Customer {
    public double clientId;
    public String clientName;
    public double contact;

    @Autowired
    public Account account;

    public Customer(double clientId,String clientName,double contact){
        this.clientId = clientId;
        this.clientName = clientName;
        this.contact = contact;
    }

    // getting and setting client ID
    public double getClientId() {
        return clientId;
    }
    public void setClientId(double clientId) {
        this.clientId = clientId;
    }

    // getting and setting client name
    public String getName() {
        return clientName;
    }
    public void setName(String clientName) {
        this.clientName = clientName;
    }

    // getting and setting client balance
    public double getContact(){
        return contact;
    }
    public void setContact(double contact) {
        this.contact = contact;
    }

    public void setAccountNo(int accountNumber){
        this.account.accountNumber = accountNumber;
    }
    public int getAccountNo(){
        return account.accountNumber;
    }
    public void setBalance(double accountBalance){
        this.account.balance = accountBalance;
    }
    public double getAccountBalance(){
        return account.balance;
    }



    public void clientDetails(){
        System.out.println("Client ID: " + clientId );
        System.out.println("Client Name: " + clientName);
        System.out.println("Client Contact: " + contact);
     //   System.out.println("Client Account No.: "+ account.getAccountNo());
        System.out.println("Client Balance: " + account.getBalance());
       // System.out.println("Client Branch: " + account.getBranch());
    }

}

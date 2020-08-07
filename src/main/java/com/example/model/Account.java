package com.example.model;

import java.time.LocalDate;

public class Account {

    private int no;
    private String name;
    private String type;
    private LocalDate balanceDate;
    private String currency;
    private double balance;

    public Account(int no, String name, String type, LocalDate balanceDate,
                   String currency, double balance) {
        super();
        this.no = no;
        this.name = name;
        this.type = type;
        this.balanceDate = balanceDate;
        this.currency = currency;
        this.balance = balance;
    }


    //Getters and Setters


    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(LocalDate balanceDate) {
        this.balanceDate = balanceDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", balanceDate=" + balanceDate +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                '}';
    }
}

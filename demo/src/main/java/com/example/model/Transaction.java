package com.example.model;

import java.time.LocalDate;

/**
 * Transaction Class
 */
public class Transaction {

    private int no;
    private String name;
    private LocalDate valueDate;
    private String currency;
    private double debitAmount;
    private double creditAmount;
    private String debitCredit;
    private String narative;

    public Transaction(int no, String name, LocalDate valueDate, String currency,
                       double debitAmount, double creditAmount, String debitCredit, String narative) {
        super();
        this.no = no;
        this.name = name;
        this.valueDate = valueDate;
        this.currency = currency;
        this.debitAmount = debitAmount;
        this.debitCredit = debitCredit;
        this.narative = narative;
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

    public LocalDate getValueDate() {
        return valueDate;
    }

    public void setValueDate(LocalDate valueDate) {
        this.valueDate = valueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(double debitAmount) {
        this.debitAmount = debitAmount;
    }

    public double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getDebitCredit() {
        return debitCredit;
    }

    public void setDebitCredit(String debitCredit) {
        this.debitCredit = debitCredit;
    }

    public String getNarative() {
        return narative;
    }

    public void setNarative(String narative) {
        this.narative = narative;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", valueDate=" + valueDate +
                ", currency='" + currency + '\'' +
                ", debitAmount=" + debitAmount +
                ", creditAmount=" + creditAmount +
                ", debitCredit='" + debitCredit + '\'' +
                ", narative='" + narative + '\'' +
                '}';
    }
}

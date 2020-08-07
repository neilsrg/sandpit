package com.example.model;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class TransactionDAO {

    public TransactionDAO() {}

    private Transactions list = new Transactions();
    private Transactions newList = new Transactions();

    {
        list.getTransactionList().add(new Transaction(321143048, "AUCurrent433", LocalDate.of(2018, 11, 8), "AUD", 0, 9540.98, "Credit", ""));
        list.getTransactionList().add(new Transaction(321143048, "AUCurrent433", LocalDate.of(2018, 11, 8), "AUD", 0, 5600.32, "Credit", ""));
        list.getTransactionList().add(new Transaction(321143048, "AUCurrent433", LocalDate.of(2018, 11, 8), "AUD", 0, 231.34, "Credit", ""));
        list.getTransactionList().add(new Transaction(321143048, "AUCurrent433", LocalDate.of(2018, 11, 8), "AUD", 0, 74.10, "Credit", ""));
        list.getTransactionList().add(new Transaction(321143048, "AUCurrent433", LocalDate.of(2018, 11, 8), "AUD", 0, 56472.99, "Credit", ""));

        list.getTransactionList().add(new Transaction(585309209, "SGSavings726", LocalDate.of(2018, 11, 8), "SGD", 0, 77283.82, "Credit", ""));
        list.getTransactionList().add(new Transaction(585309209, "SGSavings726", LocalDate.of(2018, 11, 8), "SGD", 0, 213.19, "Credit", ""));
        list.getTransactionList().add(new Transaction(585309209, "SGSavings726", LocalDate.of(2018, 11, 8), "SGD", 0, 38394.22, "Credit", ""));
    }

    public Transactions getAllTransactionsByAccNo(int no) {

        newList.getTransactionList().clear();

        for (Transaction transaction : list.getTransactionList()) {
            if (transaction.getNo() == no) {
                newList.getTransactionList().add(transaction);
            }
        }
        return newList;
    }

}

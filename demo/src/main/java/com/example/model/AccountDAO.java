package com.example.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * Account Data Object
 * To define a static data instead of accessing database (for Demo only)
 * In reality we need to define a Data Source (database) to store the Accounts data
 */
@Component
@Repository
public class AccountDAO {

    public AccountDAO() {}

    private Accounts list = new Accounts();

    {
        list.getAccountList().add(new Account(585309209, "SGSavings726", "Savings", LocalDate.of(2018, 11, 8), "SGD", 84327.51));
        list.getAccountList().add(new Account(791066619, "AUSavings933", "Savings", LocalDate.of(2018, 11, 8), "AUD", 88005.93));
        list.getAccountList().add(new Account(321143048, "AUCurrent433", "Current", LocalDate.of(2018, 11, 8), "AUD", 38010.62));
        list.getAccountList().add(new Account(347786244, "SGCurrent166", "Current", LocalDate.of(2018, 11, 8), "SGD", 50664.65));
        list.getAccountList().add(new Account(680168913, "AUSavings374", "Current", LocalDate.of(2018, 11, 8), "AUD", 41327.28));
    }

    public Accounts getAllAccounts() {
        return list;
    }
}

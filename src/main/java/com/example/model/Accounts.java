package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Accounts {

    private List<Account> accountList;

    public List<Account> getAccountList() {
        if (accountList == null) {
            accountList = new ArrayList<>();
        }
        return accountList;
    }

}

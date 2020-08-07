package com.example.demo;

import com.example.model.AccountDAO;
import com.example.model.Accounts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/accounts")
public class AccountController {
    private AccountDAO accountDAO = new AccountDAO();

    @GetMapping(path = "/", produces = "application/json")
    public Accounts getAccounts() {
        return accountDAO.getAllAccounts();
    }
}

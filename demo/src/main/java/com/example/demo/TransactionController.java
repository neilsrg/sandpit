package com.example.demo;

import com.example.model.TransactionDAO;
import com.example.model.Transactions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller to view account transactions based on the Account No provided
 */
@RestController
@RequestMapping(path = "/transactions")
public class TransactionController {

    private TransactionDAO transactionDAO = new TransactionDAO();

    @GetMapping(path = "/{accNo}", produces = "application/json")
    public Transactions getTransactions(@PathVariable int accNo) {
        return transactionDAO.getAllTransactionsByAccNo(accNo);
    }

}

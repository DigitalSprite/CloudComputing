package edu.tongji.demo.Service.DSTRHive;

import edu.tongji.demo.Model.Transaction;

import java.util.List;

public interface DSTRTransactionService {

    Boolean setTransaction(Transaction transaction);

    List<Transaction> getOrderListByTitle(String title);
}

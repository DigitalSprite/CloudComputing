package edu.tongji.demo.Service.Hive;

import edu.tongji.demo.Model.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface TransactionService {

    Boolean setTransaction(Transaction transaction);

    List<Transaction> getOrderListByTitle(String title);
}

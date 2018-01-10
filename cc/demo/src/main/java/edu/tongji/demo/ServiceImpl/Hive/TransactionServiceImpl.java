package edu.tongji.demo.ServiceImpl.Hive;

import edu.tongji.demo.Model.Transaction;
import edu.tongji.demo.Service.Hive.TransactionService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static edu.tongji.demo.Configuration.StaticConfig.*;

@Component
public class TransactionServiceImpl implements TransactionService {

    @Override
    public Boolean setTransaction(Transaction transaction){
        if(transaction == null)
            return false;
        else{
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName(DRIVER_MYSQL);
                conn = DriverManager.getConnection(DB_URL_MYSQL, USER_MYSQL, PASS_MYSQL);
                stmt = conn.createStatement();
                String product_id = transaction.getProduct_id();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = df.format(new Date());
                double price = transaction.getPrice();
                String name = "hujiaxin";
                String address = "Tongji University";
                String phone = "00000000001";
                String title = transaction.getTitle();
                String createOrder = "INSERT INTO transaction VALUES (NULL ,\'"+product_id + "\', \'"
                        +date +"\', "+price+", \'"+name+"\', \'" +address +"\', \'"+phone+"\', \'" + title + "\'";
                System.out.println(createOrder);
                ResultSet rs= stmt.executeQuery(createOrder);
                rs.close();
                stmt.close();
                conn.close();
                return true;
            } catch (SQLException se) {
                se.printStackTrace();
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    @Override
    public List<Transaction> getOrderListByTitle(String title){
        if(title.equals(""))
            return null;
        else{
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName(DRIVER);
                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                stmt = conn.createStatement();
                String query = "select * from transaction where title RLIKE \'" + title +"\'";
                ResultSet set = stmt.executeQuery(query);
                List<Transaction> list = new ArrayList<>();
                while(set.next()){
                    Transaction transaction = new Transaction();
                    transaction.setTransaction_id(set.getInt("transaction_id"));
                    transaction.setProduct_id(set.getString("product_id"));
                    transaction.setTrading_date(set.getString("trading_date"));
                    transaction.setPrice(set.getDouble("price"));
                    transaction.setName(set.getString("name"));
                    transaction.setAddress(set.getString("address"));
                    transaction.setPhone(set.getString("phone"));
                    transaction.setTitle(set.getString("title"));
                    list.add(transaction);
                }
                set.close();
                stmt.close();
                conn.close();
                return list;
            } catch (SQLException se) {
                se.printStackTrace();
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

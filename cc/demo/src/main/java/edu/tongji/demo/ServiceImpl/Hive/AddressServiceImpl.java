package edu.tongji.demo.ServiceImpl.Hive;

import edu.tongji.demo.Model.Address;
import edu.tongji.demo.Service.Hive.AddressService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.tongji.demo.Configuration.StaticConfig.*;

@Component
public class AddressServiceImpl implements AddressService {

    public List<Address> geListByAddressBy(String address){
//        final String DB_URL = "jdbc:mysql://101.132.166.73:3306/tianmao";
//        final String USER = "test";
//        final String PASS = "hjx623971";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM address WHERE address RLIKE \'%" + address + "%\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Address> list = new ArrayList<>();
            while(rs.next()){
                Address address1 = new Address();
                address1.setProduct_id(rs.getString("product_id"));
                address1.setAddress(rs.getString("address"));
                address1.setPrice(rs.getDouble("price"));
                address1.setTitle(rs.getString("title"));
                list.add(address1);
            }
            rs.close();
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

package edu.tongji.demo.ServiceImpl.DSTRHive;

import edu.tongji.demo.Model.Detail;
import edu.tongji.demo.Service.DSTRHive.DSTRDetailService;
import edu.tongji.demo.Service.Hive.DetailService;
import org.springframework.stereotype.Component;

import java.sql.*;

import static edu.tongji.demo.Configuration.StaticConfig.*;

@Component
public class DSTRDetailServiceImpl implements DSTRDetailService {

    public Detail getDetailById(String product_id){
//        final String DB_URL = "jdbc:mysql://101.132.166.73:3306/tianmao";
//        final String USER = "test";
//        final String PASS = "hjx623971";
        Connection conn = null;
        Statement stmt = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName(DRIVER_DSTR);
            conn = DriverManager.getConnection(DB_URL_DSTR, USER_DSTR, PASS_DSTR);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM detail WHERE product_id = \'" + product_id + "\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            Detail detail = new Detail();
            while(rs.next()){
;               detail.setProduct_id(product_id);
                detail.setTitle(rs.getString("title"));
                detail.setPrice(rs.getDouble("price"));
                detail.setGuarantee(rs.getString("guarantee"));
                detail.setGenre(rs.getString("genre"));
                detail.setExpress(rs.getString("express"));
                detail.setAddress(rs.getString("address"));
                detail.setIndex(rs.getString("index"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return detail;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

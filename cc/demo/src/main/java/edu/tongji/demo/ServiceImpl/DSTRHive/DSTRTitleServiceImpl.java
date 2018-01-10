package edu.tongji.demo.ServiceImpl.DSTRHive;

import edu.tongji.demo.Model.Basic;
import edu.tongji.demo.Service.DSTRHive.DSTRTitleService;
import edu.tongji.demo.Service.Hive.TitleService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.tongji.demo.Configuration.StaticConfig.*;

@Component
public class DSTRTitleServiceImpl implements DSTRTitleService{

    @Override
    public List<Basic> getbasicByTitle(String title){
//        final String DB_URL = "jdbc:mysql://101.132.166.73:3306/tianmao";
//        final String USER = "test";
//        final String PASS = "hjx623971";
        Connection conn = null;
        Statement stmt = null;
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
//            String sql = "SELECT * FROM basic WHERE title = \'[.\n]*" + title + "[.\n]*\'";
            String sql = "SELECT * FROM basic WHERE title RLIKE \'" + title+"\' limit 10";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Basic> list = new ArrayList<>();
            while(rs.next()){
//                System.out.println(rs.getString("price"));
                Basic basic = new Basic();
                basic.setProduct_id(rs.getString("product_id"));
                basic.setTitle(rs.getString("title"));
                basic.setGenre(rs.getString("genre"));
                basic.setPrice(rs.getDouble("price"));
                list.add(basic);
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

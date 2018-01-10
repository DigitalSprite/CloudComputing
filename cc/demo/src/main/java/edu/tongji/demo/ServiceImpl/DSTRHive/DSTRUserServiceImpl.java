package edu.tongji.demo.ServiceImpl.DSTRHive;

import edu.tongji.demo.Model.User;
import edu.tongji.demo.Service.DSTRHive.DSTRUserService;
import edu.tongji.demo.Service.Hive.UserService;
import org.springframework.stereotype.Component;

import java.sql.*;

import static edu.tongji.demo.Configuration.StaticConfig.*;

@Component
public class DSTRUserServiceImpl implements DSTRUserService {

    public User getUserInfo(String user_id){
//        final String DB_URL = "jdbc:mysql://101.132.166.73:3306/tianmao";
//        final String USER = "test";
//        final String PASS = "hjx623971";
        Connection conn = null;
        Statement stmt = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM user WHERE user_id = \'" + user_id + "\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            User user = new User();
            while(rs.next()){
                user = new User();
                user.setUser_id(user_id);
                user.setAccount(rs.getDouble("account"));
                user.setAddress(rs.getString("address"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
            }
            rs.close();
            stmt.close();
            conn.close();
            return user;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

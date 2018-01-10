package edu.tongji.demo.ServiceImpl.Hive;

import edu.tongji.demo.Model.Genre;
import edu.tongji.demo.Service.Hive.GenreService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.tongji.demo.Configuration.StaticConfig.*;
@Component
public class GenreServiceImpl implements GenreService {

    @Override
    public List<Genre> getListByGenre(String genre){
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
            String sql = "SELECT * FROM basic WHERE genre RLIKE \'%" + genre + "%\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Genre> list = new ArrayList<>();
            while(rs.next()){
                Genre genre1 = new Genre();
                genre1.setProduct_id(rs.getString("product_id"));
                genre1.setTitle(rs.getString("title"));
                genre1.setGenre(rs.getString("genre"));
                genre1.setPrice(rs.getDouble("price"));
                list.add(genre1);
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

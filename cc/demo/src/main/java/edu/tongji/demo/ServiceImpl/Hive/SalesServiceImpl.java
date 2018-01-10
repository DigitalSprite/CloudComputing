package edu.tongji.demo.ServiceImpl.Hive;

import edu.tongji.demo.Service.Hive.SalesSerivce;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static edu.tongji.demo.Configuration.StaticConfig.*;

@Component
public class SalesServiceImpl implements SalesSerivce {
    public static Map<Integer, Integer> mapTable = new HashMap<>();
    static{
        mapTable.put(1,0);
        mapTable.put(2,31);
        mapTable.put(3,59);
        mapTable.put(4,90);
        mapTable.put(5,120);
        mapTable.put(6,151);
        mapTable.put(7,181);
        mapTable.put(8,212);
        mapTable.put(9,243);
        mapTable.put(10,273);
        mapTable.put(11,304);
        mapTable.put(12,334);
    }

    @Override
    public Object getSalesDayData(String product_id){
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
            String sql = "SELECT * FROM sales WHERE product_id = \'" + product_id + "\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            int[] data = new int[365];
            for(int i = 0; i < data.length; i++)
                data[i] = 0;
            while(rs.next()){
                int month = rs.getInt("month");
                int day = rs.getInt("day");
                int num = mapTable.get(month) + day;
                System.out.println(num);
                data[num - 1] += 1;
            }
            rs.close();
            stmt.close();
            conn.close();
            return data;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getSalesMonthData(String product_id){
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM sales WHERE product_id = \'" + product_id + "\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            int[] data = new int[12];
            while(rs.next()){
                int month = rs.getInt("month");
                data[month - 1] += 1;
            }
            rs.close();
            stmt.close();
            conn.close();
            return data;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Object getSalesSeasonData(String product_id){Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM sales WHERE product_id = \'" + product_id + "\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            int[] data = new int[4];
            while(rs.next()){
                int month = rs.getInt("month");
                data[(month - 1)/3] += 1;
            }
            rs.close();
            stmt.close();
            conn.close();
            return data;
        } catch (SQLException se) {
            se.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}

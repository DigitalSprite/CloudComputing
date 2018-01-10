package edu.tongji.demo.ServiceImpl.DSTRHive;


import edu.tongji.demo.Model.Price;
import edu.tongji.demo.Service.DSTRHive.DSTRPriceService;
import edu.tongji.demo.Service.Hive.PriceService;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static edu.tongji.demo.Configuration.StaticConfig.*;

//import org.apache.hadoop.conf.Configuration;
//import org.apache.hadoop.hbase.HBaseConfiguration;
//import org.apache.hadoop.hbase.MasterNotRunningException;
//import org.apache.hadoop.hbase.ZooKeeperConnectionException;
//import org.apache.hadoop.hbase.client.*;
//import org.apache.hadoop.hbase.filter.CompareFilter;
//import org.apache.hadoop.hbase.filter.Filter;
//import org.apache.hadoop.hbase.filter.FilterList;
//import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
//import org.apache.hadoop.hbase.util.Bytes;

@Component
public class DSTRPriceServiceImpl implements DSTRPriceService {

    @Override
    public List<Price> getListByPriceRange(double low, double high, String title) {
//        try {
//            Configuration configuration = HBaseConfiguration.create();
//            configuration.set("hbase.zookeeper.property.clientPort", "2181"); // zookeeper客户端访问端口
//            configuration.set("hbase.zookeeper.quorum", "192.168.0.111"); // HBase集群服务器地址（任一台）
//            //HBaseAdmin admin = new HBaseAdmin(configuration);
//            HTable table = new HTable(configuration, "price");
//            List<Filter> filters = new ArrayList<>();
//
//            //配置多个filter
//            SingleColumnValueFilter filter1 = new SingleColumnValueFilter(Bytes.toBytes("price"), null
//                    , CompareFilter.CompareOp.GREATER, Bytes.toBytes(low));
//            filter1.setFilterIfMissing(true);
//            filters.add(filter1);
//
//            //filter list
//            FilterList filterList = new FilterList(filters);
//
//            //扫描获得数据集
//            Scan scan = new Scan();
//            scan.setFilter(filterList);
//            ResultScanner rs = table.getScanner(scan);
//
//            //遍历结果
//            for (Result r : rs) {
//                System.out.println(new String(r.getRow()));
//            }
//            rs.close();
//            return null;
//        } catch (MasterNotRunningException e) {
//            e.printStackTrace();
//            return null;
//        } catch (ZooKeeperConnectionException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//        final String DB_URL = "jdbc:hive2://192.168.0.111:10000/default";
//        final String USER = "";
//        final String PASS = "";
        Connection conn = null;
        Statement stmt = null;
        try {
            //Class.forName("org.apache.hive.jdbc.HiveDriver");
            Class.forName(DRIVER_DSTR);
            conn = DriverManager.getConnection(DB_URL_DSTR, USER_DSTR, PASS_DSTR);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM price WHERE price > " + low + " AND price < " + high +
                    " AND title RLIKE \'%" + title + "%\'";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
            List<Price> list = new ArrayList<>();
            while(rs.next()){
                Price price = new Price();
                price.setProduct_id(rs.getString("product_id"));
                price.setPrice(rs.getDouble("price"));
                price.setTitle(rs.getString("title"));
                list.add(price);
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

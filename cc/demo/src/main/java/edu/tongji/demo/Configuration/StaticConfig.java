package edu.tongji.demo.Configuration;

public class StaticConfig {
    public static final String DB_URL = "jdbc:hive2://192.168.0.111:10002/default";
    public static final String USER = "hive1";
    public static final String PASS = "hive1";
    public static final String DRIVER = "org.apache.hive.jdbc.HiveDriver";

    public static final String DB_URL_MYSQL = "jdbc:mysql://101.132.166.73:3306/tianmao";
    public static final String USER_MYSQL = "test";
    public static final String PASS_MYSQL = "hjx623971";
    public static final String DRIVER_MYSQL= "com.mysql.jdbc.Driver";

    public static final String DB_URL_DSTR = "jdbc:hive2://192.168.0.111:10000/default";
    public static final String USER_DSTR = "hive1";
    public static final String PASS_DSTR = "hive1";
    public static final String DRIVER_DSTR= "org.apache.hive.jdbc.HiveDriver";
}

package edu.tongji.demo.Service.Hive;

public interface SalesSerivce {

    Object getSalesDayData(String product_id);

    Object getSalesSeasonData(String product_id);

    Object getSalesMonthData(String product_id);
}

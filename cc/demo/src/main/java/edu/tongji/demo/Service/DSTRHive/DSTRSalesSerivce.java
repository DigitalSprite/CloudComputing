package edu.tongji.demo.Service.DSTRHive;

public interface DSTRSalesSerivce {

    Object getSalesDayData(String product_id);

    Object getSalesSeasonData(String product_id);

    Object getSalesMonthData(String product_id);
}

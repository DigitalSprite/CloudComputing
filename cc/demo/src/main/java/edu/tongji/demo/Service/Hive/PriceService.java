package edu.tongji.demo.Service.Hive;

import edu.tongji.demo.Model.Price;

import java.util.List;

public interface PriceService {

    List<Price> getListByPriceRange(double low, double high, String title);
}

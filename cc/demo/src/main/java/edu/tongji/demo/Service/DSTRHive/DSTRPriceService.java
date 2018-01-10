package edu.tongji.demo.Service.DSTRHive;

import edu.tongji.demo.Model.Price;

import java.util.List;

public interface DSTRPriceService {

    List<Price> getListByPriceRange(double low, double high, String title);
}

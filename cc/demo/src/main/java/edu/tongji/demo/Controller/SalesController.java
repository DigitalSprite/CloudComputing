package edu.tongji.demo.Controller;

import edu.tongji.demo.Service.Hive.SalesSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesSerivce salesSerivce;

    @GetMapping("/statistic")
    public Object getSalesDayData(@RequestParam(value = "id", defaultValue = "")String product_id,
                                  @RequestParam(value = "type", defaultValue = "")String type){
        try{
            Map<String, Object> result = new HashMap<>();
            Object data = null;
            long start = System.currentTimeMillis();
            switch (type){
                case "1": data = salesSerivce.getSalesDayData(product_id);break;
                case "2": data = salesSerivce.getSalesMonthData(product_id);break;
                case "3": data = salesSerivce.getSalesSeasonData(product_id);break;
                default: result = null;
            }
            long end = System.currentTimeMillis();
            result.put("data", data);
            result.put("time", ((double)(end - start))/1000);
            return result;
        }catch (Exception e){
            System.out.println(e);
            return 400;
        }
    }
}

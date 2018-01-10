package edu.tongji.demo.Controller;

import edu.tongji.demo.Model.Price;
import edu.tongji.demo.Service.Hive.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/price")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping("/index")
    public Object getListByPriceRange(@RequestParam(value = "low", defaultValue = "0") String low,
                                      @RequestParam(value = "high", defaultValue = "10000") String high,
                                      @RequestParam(value = "title", defaultValue = "")String title){
        try{
            Map<String, Object> result = new HashMap<>();
            long start = System.currentTimeMillis();
            if(title.equals("")){
                result.put("data", null);
                result.put("number", 0);
            }else{
                List<Price> data = priceService.getListByPriceRange(Double.parseDouble(low),Double.parseDouble(high), title);
                result.put("data", data);
                result.put("number", data.size());
            }
            long end = System.currentTimeMillis();
            result.put("time", ((double)(end - start))/1000);
            return result;
        }catch (Exception e){
            System.out.println(e);
            return 400;
        }

    }
}

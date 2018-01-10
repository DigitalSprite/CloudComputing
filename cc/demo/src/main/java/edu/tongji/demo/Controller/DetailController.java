package edu.tongji.demo.Controller;


import edu.tongji.demo.Model.Detail;
import edu.tongji.demo.Service.Hive.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/detail")
public class DetailController {

    @Autowired
    private DetailService detailService;

    @GetMapping("/index")
    public Object getDetailById(@RequestParam(value = "id", defaultValue = "")String id){
        try{
            Map<String, Object> result = new HashMap<>();
            long start = System.currentTimeMillis();
            Detail detail = null;
            if(!id.equals(""))
                detail = detailService.getDetailById(id);
            long end = System.currentTimeMillis();
            result.put("data", detail);
            result.put("time", ((double)(end - start))/1000);
            return result;
        }catch (Exception e){
            System.out.println(e);
            return 400;
        }
    }
}

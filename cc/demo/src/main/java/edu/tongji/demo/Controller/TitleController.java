package edu.tongji.demo.Controller;

import edu.tongji.demo.Model.Basic;
import edu.tongji.demo.Service.Hive.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @GetMapping("index")
    public Object getBasicByTitle(@RequestParam(value = "title", defaultValue = "")String title){
        try{
            Map<String, Object> result = new HashMap<>();
            long start = System.currentTimeMillis();
            if(title.equals("")){
                result.put("data", null);
                result.put("number", 0);
            }else{
                List<Basic> list = titleService.getbasicByTitle(title);
                result.put("data", list);
                result.put("number", list.size());
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

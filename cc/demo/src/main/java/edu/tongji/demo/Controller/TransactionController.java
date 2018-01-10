package edu.tongji.demo.Controller;

import edu.tongji.demo.Model.Transaction;
import edu.tongji.demo.Service.Hive.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
//    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    public @ResponseBody Object test(UserInfo data, HttpServletRequest request, HttpServletResponse response){
//        try{
//            if (!userService.verify(data.getName(), data.getPassword()))
//                return "400";
//            else {
//                userService.addSession(data.getName(), data.getPassword(), request, response);
//                return "200";
//            }
//        }catch (Exception e){
//            return "404";
//        }
//    }
    @PostMapping(value = "/insert", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public @ResponseBody Object test(Transaction transaction){
        Map<String, Object> result = new HashMap<>();
        long start = System.currentTimeMillis();
        try{
            boolean test = transactionService.setTransaction(transaction);
            result.put("data",test);
        }catch (Exception e){
            result.put("data", false);
        }
        long end = System.currentTimeMillis();
        result.put("number",((double)(end - start))/1000);
        return result;
    }

    @GetMapping("/history")
    public Object getHistoryDataByTitle(@RequestParam(value = "title", defaultValue = "")String title){
        try{
            Map<String, Object> result = new HashMap<>();
            long start = System.currentTimeMillis();
            if(title.equals("")){
                result.put("data", null);
                result.put("number", 0);
            }
            else{
                List<Transaction> list = transactionService.getOrderListByTitle(title);
                result.put("data", list);
                result.put("number", list.size());
            }
            long end = System.currentTimeMillis();
            result.put("time", ((double)(end - start))/1000);
            return result;
        }catch (Exception e){
            return 400;
        }
    }
}
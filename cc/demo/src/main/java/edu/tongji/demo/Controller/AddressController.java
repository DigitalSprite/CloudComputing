package edu.tongji.demo.Controller;


import edu.tongji.demo.Model.Address;
import edu.tongji.demo.Service.DSTRHive.DSTRAddressService;
import edu.tongji.demo.Service.Hive.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private DSTRAddressService dstrAddressService;

    @GetMapping("/index")
    public Object getListByAddress(@RequestParam(value = "address", defaultValue = "")String address){
        try{
            Map<String, Object> result = new HashMap<>();
            List<Address> data = null;
            int number = 0;
            long start = System.currentTimeMillis();
            if(address.equals(""))
                data = null;
            else{
                data = addressService.geListByAddressBy(address);
                number = data.size();
            }
            long end = System.currentTimeMillis();
            result.put("data", data);
            result.put("time", ((double)(end - start))/1000);
            result.put("number", number);
            return result;
        }catch (Exception e){
            System.out.println(e);
            return 400;
        }
    }

    @GetMapping("/dstr")
    public Object indexDSTR(@RequestParam(value = "address", defaultValue = "")String address){
        try{
            Map<String, Object> result = new HashMap<>();
            long start = System.currentTimeMillis();
            if(!address.equals(""))
                dstrAddressService.geListByAddressBy(address);
            long end = System.currentTimeMillis();
            result.put("dstr_time", ((double)(end - start))/1000);
            return result;
        }catch (Exception e){
            System.out.println(e);
            return 400;
        }
    }
}

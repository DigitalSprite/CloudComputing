package edu.tongji.demo.Controller;


import edu.tongji.demo.Model.User;
import edu.tongji.demo.Service.Hive.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/info")
    public Object getUserInfo(@RequestParam(value = "id")String id){
        try{
            User user = userService.getUserInfo(id);
            if(user == null)
                return 404;
            return user;
        }catch (Exception e){
            System.out.println(e);
            return 400;
        }
    }
}

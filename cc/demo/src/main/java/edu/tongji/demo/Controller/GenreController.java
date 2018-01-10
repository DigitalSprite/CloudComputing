package edu.tongji.demo.Controller;

import edu.tongji.demo.Model.Genre;
import edu.tongji.demo.Service.Hive.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/genre")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/index")
    public Object getListByGenre(@RequestParam(value = "genre", defaultValue = "")String genre){
        try{
            Map<String, Object> result = new HashMap<>();
            long start = System.currentTimeMillis();
            if(genre.equals("")){
                result.put("data", null);
                result.put("number", 0);
            }
            else{
                List<Genre> data = genreService.getListByGenre(genre);
                result.put("data", data);
                result.put("number", data.size());
            }
            long end = System.currentTimeMillis();
            result.put("time", ((double)(end - start))/1000);
            return result;
        }catch ( Exception e){
            System.out.println(e);
            return 400;
        }

    }
}

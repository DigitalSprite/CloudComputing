package edu.tongji.demo.Service.Hive;

import edu.tongji.demo.Model.Genre;

import java.util.List;

public interface GenreService {

    List<Genre> getListByGenre(String genre);
}

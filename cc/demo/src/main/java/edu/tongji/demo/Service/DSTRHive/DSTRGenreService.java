package edu.tongji.demo.Service.DSTRHive;

import edu.tongji.demo.Model.Genre;

import java.util.List;

public interface DSTRGenreService {

    List<Genre> getListByGenre(String genre);
}

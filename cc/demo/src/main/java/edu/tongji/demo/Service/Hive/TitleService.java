package edu.tongji.demo.Service.Hive;

import edu.tongji.demo.Model.Basic;

import java.util.List;

public interface TitleService {

    List<Basic> getbasicByTitle(String title);

}

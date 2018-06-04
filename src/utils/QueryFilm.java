package utils;

import Bean.Film;
import Bean.Firm;
import database.DBOperator;

import java.util.ArrayList;
import java.util.List;

public class QueryFilm {

    private Film film;

    private String username;
    private String password;
    private String sql="select * from Film ";

    private List<Film> filmList = new ArrayList<>();

    //电影名称查询构造函数
    public QueryFilm(String filmName){
        this.sql = this.sql + " where FilmName=" + filmName + " ;";
    }

    public void executeQuery(){
        DBOperator dbOperator = new DBOperator(this.username,this.password,"film");
        dbOperator.query(this.sql);
        this.filmList = dbOperator.getFilmList();
    }


    public List<Film> getFilmList() {
        return filmList;
    }
}

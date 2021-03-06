package utils;

import Bean.Film;
import database.DBOperator;

public class InsertFilm {
    private Film film;
    private String sql;
    private String preSql;

    public InsertFilm(Film film){
        this.film = film;
        this.sql = "insert into Film (FilmID, FirmID, FilmName, FilmYear, FilmLength, FilmPlot) values" +
                " ('" + this.film.getFilmID() + "', '" + this.film.getFilmName() + "', '";
        this.preSql = "select FirmID from Firm where FirmName='" + this.film.getPublishFirm() + "' ;";
    }

    public int executeInsert(){
        int affectRows;
        String username = "root1";
        String password = "L90efcad1";
        DBOperator dbOperator = new DBOperator(username,password);
        String firmID = dbOperator.preQueryFirmID(this.preSql);
        this.setSql(firmID);
        affectRows = dbOperator.update(this.sql);
        return affectRows;
    }

    public void setSql(String firmID) {
        this.sql = "insert into Film (FilmID, FirmID, FilmName, FilmYear, FilmLength, FilmPlot) values" +
                " ('" + this.film.getFilmID() + "', '" + firmID + "', '" + this.film.getFilmName() + "', '" +
                this.film.getPublishYear() + "', '" + this.film.getLength() + "', '" + this.film.getPlot() + "');";
    }
}

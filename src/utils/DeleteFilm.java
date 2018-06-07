package utils;

import database.DBOperator;

public class DeleteFilm {

    private String username = "root1";
    private String password = "L90efcad1";

    private String filmID;
    private String filmName;

    private String sql;

    public DeleteFilm(String filmID){
        this.filmID = filmID;
        this.sql = this.sql + filmID + "' ;";
    }

    public DeleteFilm(String filmID,String filmName){
        this.filmID = filmID;
        this.filmName = filmName;
        this.sql = "delete from Film where FilmID='" + filmID + "' ;";
    }

    public int executeDelete(){
        DBOperator dbOperator = new DBOperator(this.username,this.password,"film");
        int affectRows = dbOperator.update(this.sql);
        return affectRows;
    }



}

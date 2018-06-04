package database;


import Bean.Film;
import Bean.Firm;
import Bean.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * 数据库操作类
 */
public class DBOperator {
    private static String url="jdbc:mysql://localhost:3306/FilmSystem?useSSL=false&useUnicode=true&amp;characterEncoding=UTF-8";
    private static String driverName = "com.mysql.jdbc.Driver";
    private String user;
    private String password;


    private String tableName;
    private Connection conn;
    private Statement statement;
    private String sql;
    private ResultSet rs;

    public String operateObject;
    //操作对象,film:查Film实体，person:查Person实体，firm:查Firm实体，actor:查Actor关系，
    // director:查Director关系，voice:查Voice关系，category:查类别关系

    private List<Person> personList = new ArrayList<>();
    private List<Film> filmList = new ArrayList<>();
    private List<Firm> firmList = new ArrayList<>();

    public DBOperator(String user, String password,String operateObject){
        this.user = user;
        this.password = password;
        this.operateObject = operateObject;
    }

    public Connection getSqlConnection(){
        Connection sqlConnection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            sqlConnection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sqlConnection;
    }

    /**
     * 获取Statement
     * @return statement
     * @throws SQLException
     */
    public Statement getStatement(){
        if(conn == null){
            conn = getSqlConnection();
        }
        if(statement == null){
            try {
                statement = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }

    /**
     * 执行查询sql语句
     * @param sql
     */
    public void query(String sql){
        ResultSet resultSet = null;
        Statement statement = getStatement();
        try {
            resultSet = statement.executeQuery(sql);
            //查询电影
            if(this.operateObject.equals("film")){
                while(resultSet.next()){
                    String filmID = resultSet.getString("FilmID");
                    String firmID = resultSet.getString("FirmID");
                    String filmName = resultSet.getString("FilmName");
                    String filmYear = resultSet.getString("FilmYear");
                    String filmLength = resultSet.getString("FilmLength");
                    String filmPlot = resultSet.getString("FilmPlot");

                    String firmName = "";

                    String sql1 = "select FirmName from Firm where FirmID=" + firmID + " ;";
                    String sql2 = "select * from Actor where FilmID=" + filmID + " ;";
                    String sql3 = "select PersonID from Director where FilmID=" + filmID + " ;";
                    String sql4 = "select PersonID from Voice where FilmID=" + filmID + " ;";
                    String sql5 = "select DYLB_LB from Category where FilmID=" + filmID + " ;";


                    ResultSet resultSet1 = statement.executeQuery(sql1);
                    ResultSet resultSet2 = statement.executeQuery(sql2);
                    ResultSet resultSet3 = statement.executeQuery(sql3);
                    ResultSet resultSet4 = statement.executeQuery(sql4);
                    ResultSet resultSet5 = statement.executeQuery(sql5);
                    while(resultSet1.next()){
                        firmName = resultSet1.getString("FirmName");
                    }
                    while(resultSet2.next()){
                        String personID = resultSet2.getString("PersonID");
                        String role = resultSet2.getString("Role");
                        String sqlPerson = "select * from Person where PersonID=" + personID + " ;";

                    }
                    Film film = new Film(filmID,filmName,filmYear,firmName,filmLength,null,null,null
                    ,null,filmPlot);

                    filmList.add(film);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * 执行更新sql语句
     * @param sql
     * @return
     */
    public int update(String sql) {
        int result = 0;
        try {
            Statement statement = getStatement();
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void close() {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getTableName() {
        return tableName;
    }

    public String getSql() {
        return sql;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public List<Firm> getFirmList() {
        return firmList;
    }
}

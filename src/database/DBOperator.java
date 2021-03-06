package database;


import Bean.Actor;
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
    private String user;
    private String password;

    private Connection conn;
    private Statement statement;

    public String operateObject;
    //操作对象,film:查Film实体，person:查Person实体，firm:查Firm实体，actor:查Actor关系，
    // director:查Director关系，voice:查Voice关系，category:查类别关系

    private List<Person> personList = new ArrayList<>();
    private List<Film> filmList = new ArrayList<>();
    private List<Firm> firmList = new ArrayList<>();
    private Firm firm;

    /**
     * 查询所用构造函数
     * @param user
     * @param password
     * @param operateObject
     */
    public DBOperator(String user, String password,String operateObject){
        this.user = user;
        this.password = password;
        this.operateObject = operateObject;
    }

    /**
     * 普通构造函数
     * @param user
     * @param password
     */
    public DBOperator(String user,String password){
        this.user = user;
        this.password = password;
    }

    public Connection getSqlConnection(){
        Connection sqlConnection = null;
        try {
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String url = "jdbc:mysql://localhost:3306/film?useSSL=false&useUnicode=true&amp;characterEncoding=UTF-8";
            sqlConnection = DriverManager.getConnection(url,this.user,this.password);
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
            //查询电影，返回结果为电影基本信息和出品公司名称，然后再查对应的类别、演员、导演、旁白
            if(this.operateObject.equals("film")){
                while(resultSet.next()){
                    String filmID = resultSet.getString("FilmID");
                    String firmName = resultSet.getString("FirmName");
                    String filmName = resultSet.getString("FilmName");
                    String filmYear = resultSet.getString("FilmYear");
                    String filmLength = resultSet.getString("FilmLength");
                    String filmPlot = resultSet.getString("FilmPlot");


                    String sql1 = "select DYLB_LB from Category where FilmID=" + filmID + " ;";
                    String sql2 = "select Person.* from Film,Actor,Person " +
                            "where FilmID=" + filmID + " and Film.FilmID=Actor.FilmID and Actor.PersonID=Person.PersonID ;";
                    String sql3 = "select Person.* from Film,Director,Person " +
                            "where FilmID=" + filmID + " and Film.FilmID=Director.FilmID and Director.PersonID=Person.PersonID ;";
                    String sql4 = "select Person.* from Film,Voice,Person " +
                            "where FilmID=" + filmID + " and Film.FilmID=Voice.FilmID and Voice.PersonID=Person.PersonID ;";



                    ResultSet resultSet1 = statement.executeQuery(sql1);
                    ResultSet resultSet2 = statement.executeQuery(sql2);
                    ResultSet resultSet3 = statement.executeQuery(sql3);
                    ResultSet resultSet4 = statement.executeQuery(sql4);

                    List<String> categoryList = new ArrayList<>();
                    List<Person> actorList;
                    List<Person> directorList;
                    List<Person> voiceList;

                    while(resultSet1.next()){
                        String category = resultSet1.getString("DYLB_LB");
                        categoryList.add(category);
                    }
                    actorList = getResultPerson(resultSet2);
                    directorList = getResultPerson(resultSet3);
                    voiceList = getResultPerson(resultSet4);
                    Film film = new Film(filmID,filmName,filmYear,firmName,filmLength,
                            categoryList,directorList,actorList,voiceList,filmPlot);
                    filmList.add(film);
                }
            }
            //查询出品公司
            else if(this.operateObject.equals("firm")){
                while(resultSet.next()){
                    String firmID = resultSet.getString("FirmID");
                    String firmName = resultSet.getString("FirmName");
                    String firmCity = resultSet.getString("FirmCity");

                    List<String> filmNameList = new ArrayList<>();
                    String sql1 = "select FilmName from Film where FirmID='" + firmID + "' ;";
                    ResultSet resultSet1 = statement.executeQuery(sql1);
                    while(resultSet1.next()){
                        String filmName = resultSet1.getString("FilmName");
                        filmNameList.add(filmName);
                    }
                    this.firm = new Firm(firmID,firmName,firmCity,filmNameList);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.close();
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

    /**
     * 更新电影前的预查询函数
     * @param sql
     * @return
     */
    public String preQueryFirmID(String sql){
        Statement statement = getStatement();
        String firmID = null;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                firmID = resultSet.getString("FirmID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return firmID;
    }

    /**
     * 关闭SQL连接和Statement
     */
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

    /**
     *
     * @param resultSet
     * @return personList
     * @throws SQLException
     */
    //获取查询人物结果函数
    private List<Person> getResultPerson(ResultSet resultSet) throws SQLException {
        List<Person> personList = new ArrayList<>();
        while(resultSet.next()){
            String personName = resultSet.getString("PersonName");
            String personID = resultSet.getString("PersonID");
            String personBirth = resultSet.getString("PersonBirth");
            Person person = new Person(personID,personName,personBirth,null,null,null);
            personList.add(person);
        }
        return personList;
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

    public Firm getFirm() {
        return firm;
    }
}

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

    private List<Person> personList = new ArrayList<>();
    private List<Film> filmList = new ArrayList<>();
    private List<Firm> firmList = new ArrayList<>();

    public DBOperator(String user, String password, String tableName, String sql){
        this.user = user;
        this.password = password;
        this.tableName = tableName;
        this.sql = sql;
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
     * @return
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
     * @return
     */
    public void query(String sql){
        ResultSet resultSet = null;
        Statement statement = getStatement();
        try {
            resultSet = statement.executeQuery(sql);
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
}

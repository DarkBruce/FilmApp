package database;

import user.Manager;
import user.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBLogin {

    private String username;
    private String password;
    private Boolean isManager;

    private static String url="jdbc:mysql://localhost:3306/FilmSystemUser?useSSL=false&useUnicode=true&amp;characterEncoding=UTF-8";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String DBusername1 = "user1";
    private static String DBpassword1 = "i9Gauf58Ol";

    private String tableName;
    private Connection conn;
    private Statement statement;
    private ResultSet rs;
    private Manager manager;
    private User user;

    public DBLogin(String username, String password,Boolean isManager){
        this.username = username;
        this.password = password;
        this.isManager = isManager;

    }

    public Connection getSqlConnection(){
        Connection sqlConnection = null;
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            sqlConnection = DriverManager.getConnection(url,DBusername1,DBpassword1);
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
    public void query(String sql) throws SQLException {
        ResultSet resultSet = null;
        Statement statement = getStatement();
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isManager){
            String managerID = resultSet.getString("managerID");
            String managerName = resultSet.getString("managerName");
            String managerPW = resultSet.getString("managerPW");
            manager = new Manager(managerID,managerName,managerPW);
        }
        else{
            String userID = resultSet.getString("userID");
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            user = new User(userID,username,password);
        }

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


    public Manager getManager() {
        return manager;
    }

    public User getUser() {
        return user;
    }
}

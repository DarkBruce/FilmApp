package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBLogin {

    private static String url="jdbc:mysql://localhost:3306/FilmSystem?useSSL=false&useUnicode=true&amp;characterEncoding=UTF-8";
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String DBusername = "user1";
    private static String DBpassword = "i9Gauf58Ol";
    private static String sql1 = "SELECT * FROM user where username=";

    private String tableName;
    private Connection conn;
    private Statement statement;
    private String sql;
    private ResultSet rs;

    public DBLogin(){

    }


}

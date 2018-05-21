package utils;


import database.DBLogin;

/**
 * 注册类
 * username, password, isManager
 * 用户名，口令，管理员标志位
 */

public class Register {

    private String username;
    private String password;
    private Boolean isManager;
    private DBLogin dbLogin;

    private String sql;


    public Register(String username,String password,Boolean isManager){
        this.username = username;
        this.password = password;
        this.isManager = isManager;
    }

    public String makeSQL(String username,String password,Boolean isManager){
        String sql = "Insert into ";
        if(isManager){
            sql = sql + " user";
        }
        else{
            sql = sql + " manager";
        }
        sql = sql + "(username,password) values (" + username + "," + password + ");";
        return sql;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getManager() {
        return isManager;
    }
}

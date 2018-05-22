package utils;


import database.DBLogin;
import user.Manager;
import user.User;

import java.sql.SQLException;
import java.util.List;

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
    private boolean existedFlag;
    public String errorInfo;

    private User user;
    private Manager manager;

    public Register(String username,String password,Boolean isManager){
        this.username = username;
        this.password = password;
        this.isManager = isManager;
        this.existedFlag = false;
        this.sql = makeSQL(username,password,isManager);
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

    public void checkExisted(){
        String sql1 = "";
        //构造SQL语句
        if(isManager){
            sql1 = sql1 + "select * from manager where username=" + this.username + " ;";
        }
        else{
            sql1 = sql1 + "select * from user where username=" + this.username + " ;";
        }

        DBLogin dbLogin = new DBLogin(this.username,this.password,this.isManager);
        try {
            dbLogin.query(sql1);
            if(dbLogin.getNullFlag()){
                this.existedFlag = false;
            }
            else{
                this.existedFlag = true;
                this.errorInfo = "Username " + this.username + " has already existed!";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeRegister(){
        if(!this.existedFlag){
            //没有已存在的用户名，注册成功
            DBLogin dbLogin = new DBLogin(this.username,this.password,this.isManager);
            int rows = dbLogin.update(sql);
            if(isManager)
                this.manager = new Manager(username,password);
            else
                this.user = new User(username,password);
        }
    }

    public boolean getExistedFlag(){
        return existedFlag;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public User getUser() {
        return user;
    }
    public Manager getManager() {
        return manager;
    }
}

package utils;

import database.DBLogin;
import user.Manager;
import user.User;

import java.sql.SQLException;

/**
 * 登录类
 * username, password, isManager
 * 用户名，口令，管理员标志位
 */

public class Login {

    private String username;
    private String password;
    private boolean isManager = false;
    private DBLogin dbLogin;

    private String sql;
    private Manager manager;
    private User user;
    public Boolean isCorrect = false;

    public Login(String username, String password, Boolean isManager){
        this.username = username;
        this.password = password;
        this.isManager = isManager;
        if(isManager)
            sql = "SELECT * FROM manager where managerName=" + this.username + " ;";    //如果是管理员则查管理员表
        else
            sql = "SELECT * FROM user where username="+ this.username + " ;";           //如果是普通用户则查普通用户表
        this.dbLogin = new DBLogin(username,password,isManager);
    }

    public void Check(){
        try {
            this.dbLogin.query(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //如果是管理员
        if(isManager){
            this.manager = this.dbLogin.getManager();
            if(username.equals(manager.getManagerName())&&password.equals(manager.getManagerPW()))  //管理员用户名密码组判断
                isCorrect = true;
        }
        else{   //如果是普通用户
            this.user = this.dbLogin.getUser();
            if(username.equals(user.getUsername())&&password.equals(user.getPassword()))            //普通用户 用户名密码组判断
                isCorrect = true;
        }
    }

    public boolean isManager() {
        return isManager;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Manager getManager(){
        return manager;
    }

    public User getUser() {
        return user;
    }
}

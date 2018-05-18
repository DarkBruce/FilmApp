package user;

/**
 * 普通用户类
 *
 */
public class User {

    private String userID;          //用户编号
    private String username;        //用户名
    private String password;        //口令


    private String DBuser = "normaluser";       //普通用户的数据库用户名口令组
    private String DBpassword = "123456";

    public User(String userID,String username, String password ){
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUserID() {
        return userID;
    }
}

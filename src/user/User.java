package user;

/**
 * 普通用户类
 *
 */
public class User {

    private String username;        //用户名
    private String password;        //口令
    private String userID;          //用户编号

    private String DBuser = "normaluser";
    private String DBpassword = "123456";

    public User(String username, String password, String userID){
        this.username = username;
        this.password = password;
        this.userID = userID;
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

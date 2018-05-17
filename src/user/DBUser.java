package user;


/**
 * 数据库用户类
 */

public class DBUser {

    private String username;
    private String password;

    public DBUser(String username, String password){
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

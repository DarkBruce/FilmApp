package utils;

import user.DBUser;

public class Login {

    private DBUser dbUser;


    public Login(String username, String password){
        this.dbUser = new DBUser(username,password);
    }


    public DBUser getDbUser() {
        return dbUser;
    }
}

package user;

public class Manager {
    /**
     * 管理员用户类
     *
     */
    private String managerID;
    private String managerName;
    private String managerPassword;

    private String DBuser = "root1";
    private String DBpassword = "L90efcad1";


    public String getManagerID() {
        return managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPassword() {
        return managerPassword;
    }

    public String getDBuser() {
        return DBuser;
    }

    public String getDBpassword() {
        return DBpassword;
    }
}

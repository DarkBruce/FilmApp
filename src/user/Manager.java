package user;

public class Manager {
    /**
     * 管理员用户类
     *
     */
    private String managerID;               //管理员ID
    private String managerName;             //管理员姓名
    private String managerPassword;         //管理员口令

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

package user;

public class Manager {
    /**
     * 管理员用户类
     *
     */
    private String managerID;               //管理员ID
    private String managerName;             //管理员姓名
    private String managerPW;         //管理员口令

    private String DBuser = "root1";
    private String DBpassword = "L90efcad1";

    public Manager(String managerID, String managerName, String managerPW) {
        this.managerID = managerID;
        this.managerName = managerName;
        this.managerPW = managerPW;
    }


    public String getManagerID() {
        return managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public String getManagerPW() {
        return managerPW;
    }

    public String getDBuser() {
        return DBuser;
    }

    public String getDBpassword() {
        return DBpassword;
    }
}

package Bean;

public class Firm {
    private String firmID;
    private String firmName;
    private String city;

    public Firm(String firmID, String firmName, String city){
        this.firmID = firmID;
        this.firmName = firmName;
        this.city = city;
    }

    public String getFirmID() {
        return firmID;
    }

    public String getFirmName() {
        return firmName;
    }

    public String getCity() {
        return city;
    }
}

package CMS;

import DBHandler.PoliceOfficerHandler;

public class PoliceOfficer {
    private static PoliceOfficer instance = null;

    private int officerID;
    private int badgeNumber;
    private String password;
    private String rank;

    PoliceOfficerHandler handler = new PoliceOfficerHandler();

    private PoliceOfficer() {
    }

    public static PoliceOfficer getInstance() {
        if (instance == null) {
            instance = new PoliceOfficer();
        }
        return instance;
    }

    public int getOfficerID() {
        return officerID;
    }

    public void setOfficerID(int officerID) {
        this.officerID = officerID;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void setBadgeNumber(int badgeNumber) {
        this.badgeNumber = badgeNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int login(int badgeNumber, String password){
        return handler.getPoliceOfficer(badgeNumber, password);
    }


}


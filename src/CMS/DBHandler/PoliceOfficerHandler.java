package CMS.DBHandler;

import java.sql.*;

import CMS.PoliceOfficer;

public class PoliceOfficerHandler {

    public int getPoliceOfficer(int badgeNumber, String password) {
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        String stat = "select * from policeofficer where badgenumber = " + badgeNumber + " AND password = '" + password + "'";
        try {
            Statement coStatement = conn.createStatement();
            ResultSet resultSet = coStatement.executeQuery(stat);
            PoliceOfficer policeOfficer = PoliceOfficer.getInstance();
            // resultSet.next();
            if (!resultSet.next()) {
                policeOfficer.setOfficerID(-1);
                return -1;
            }
            else{
                policeOfficer.setOfficerID(resultSet.getInt("officer_id"));
                policeOfficer.setBadgeNumber(badgeNumber);
                policeOfficer.setPassword(password);
                policeOfficer.setRank(resultSet.getString("Rank"));
                return resultSet.getInt("officer_id");
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return -1;

    }
}

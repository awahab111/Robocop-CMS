package CMS.DBHandler;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import CMS.Notification;

public class NotificationHandler {
    public void insertNotification(String type, String message) {
        java.util.Date currentDate = new java.util.Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(currentDate);
        java.sql.Date sqlDate = java.sql.Date.valueOf(formattedDate);

        // Create a time variable with the current time
        java.sql.Time sqlTime = new java.sql.Time(currentDate.getTime());
        
        String query = "INSERT INTO notifications (notif_type, notif_desc, pub_date, pub_time) VALUES ('" + type + "', '" + message + "', '" + sqlDate + "', '" + sqlTime + "')";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            coStatement.executeUpdate(query);
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }

    public ArrayList<Notification> getAllNotifications() {
        ArrayList<Notification> notifications = new ArrayList<Notification>();
        String query = "SELECT * FROM notifications order by pub_date desc, pub_time desc";
        Database db = new Database();
        java.sql.Connection conn = db.getconn();
        try{
            Statement coStatement = conn.createStatement();
            java.sql.ResultSet rs = coStatement.executeQuery(query);
            while(rs.next()){
                Notification notification = new Notification();
                notification.setType(rs.getString("notif_type"));
                notification.setMessage(rs.getString("notif_desc"));
                notification.setDate(rs.getString("pub_date"));
                notification.setTime(rs.getString("pub_time"));
                notifications.add(notification);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return notifications;
    }
}

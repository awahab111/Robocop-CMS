package CMS;

import CMS.DBHandler.NotificationHandler;

public class Notification {
    private String type;
    private String message;
    private String date;
    private String time;
    private String settings;

    private NotificationHandler notificationHandler = new NotificationHandler();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSettings() {
        return settings;
    }

    public void setSettings(String settings) {
        this.settings = settings;
    }
}



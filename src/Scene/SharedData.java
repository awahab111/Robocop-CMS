package Scene;

import CMS.User;

public class SharedData {
    private static SharedData instance = null;
    private static User user;

    private SharedData() {}

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public static void setUser(User user) {
        SharedData.user = user;
    }

    public static User getUser() {
        return user;
    }
}

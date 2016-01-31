package reminders.ifreedomer.com.dancing;

import reminders.ifreedomer.com.dancing.bean.User;

/**
 * Created by eavawu on 1/31/16.
 */
public class Global {
    public static User getmGlobalUser() {
        return mGlobalUser;
    }

    public static void setmGlobalUser(User mGlobalUser) {
        Global.mGlobalUser = mGlobalUser;
    }

    public static User mGlobalUser;
}

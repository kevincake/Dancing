package reminders.ifreedomer.com.dancing;

import reminders.ifreedomer.com.dancing.bean.Lesson;
import reminders.ifreedomer.com.dancing.bean.SMSVerifyBean;
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
    public static SMSVerifyBean mGlobalVerifyBean ;
    public static Lesson mLesson;

    public static Lesson getmLesson() {
        return mLesson;
    }

    public static void setmLesson(Lesson mLesson) {
        Global.mLesson = mLesson;
    }

    public static SMSVerifyBean getmGlobalVerifyBean() {
        return mGlobalVerifyBean;
    }

    public static void setmGlobalVerifyBean(SMSVerifyBean mGlobalVerifyBean) {
        Global.mGlobalVerifyBean = mGlobalVerifyBean;
    }
}

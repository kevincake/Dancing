package reminders.ifreedomer.com.dancing.bean;

/**
 * Created by eavawu on 1/21/16.
 */
public class SMSVerifyBean {
    public static String phoneNum;
    public static String contryCode;
    public static String verifyCode;

    public static String getContryCode() {
        return contryCode;
    }

    public static void setContryCode(String contryCode) {
        SMSVerifyBean.contryCode = contryCode;
    }

    public static String getVerifyCode() {
        return verifyCode;
    }

    public static void setVerifyCode(String verifyCode) {
        SMSVerifyBean.verifyCode = verifyCode;
    }

    public static String getPhoneNum() {
        return phoneNum;
    }

    public static void setPhoneNum(String phoneNum) {
        SMSVerifyBean.phoneNum = phoneNum;
    }
}

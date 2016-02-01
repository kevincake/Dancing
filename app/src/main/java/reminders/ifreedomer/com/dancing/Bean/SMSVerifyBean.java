package reminders.ifreedomer.com.dancing.bean;

/**
 * Created by eavawu on 1/21/16.
 */
public class SMSVerifyBean {
    public String phoneNum;
    public String contryCode;
    public String verifyCode;

    public String getContryCode() {
        return contryCode;
    }

    public void setContryCode(String contryCode) {
        this.contryCode = contryCode;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}

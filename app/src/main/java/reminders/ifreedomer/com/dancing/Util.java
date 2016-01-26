package reminders.ifreedomer.com.dancing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eavawu on 1/18/16.
 */
public class Util {
    /**
     * 通用判断
     * @param telNum
     * @return
     */
    public static boolean isMobiPhoneNum(String telNum){
        String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(telNum);
        return m.matches();
    }
}

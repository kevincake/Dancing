package reminders.ifreedomer.com.dancing;

import android.content.Context;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Toast;

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

    /**
     * 通用白色的Toast
     * @param ctx
     * @param desStr
     * @param time
     */
    public static void showWhiteToast(Context ctx,String desStr,int time){
        Toast toast = Toast.makeText(ctx, desStr, time);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.WHITE);
        toast.show();
    }
}

package reminders.ifreedomer.com.dancing;

import android.content.Context;
import android.graphics.Color;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by eavawu on 1/18/16.
 */
public class Util {
    /**
     * 通用判断
     *
     * @param telNum
     * @return
     */
    public static boolean isMobiPhoneNum(String telNum) {
        String regex = "^((13[0-9])|(15[0-9])|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(telNum);
        return m.matches();
    }

    /**
     * 通用白色的Toast
     *
     * @param ctx
     * @param desStr
     * @param time
     */
    public static void showWhiteToast(Context ctx, String desStr, int time) {
        Toast toast = Toast.makeText(ctx, desStr, time);
        TextView v = (TextView) toast.getView().findViewById(android.R.id.message);
        v.setTextColor(Color.WHITE);
        toast.show();
    }

    /**
     * 判断密码是否合法
     *
     * @param str
     * @return
     */
    public static boolean isPassword(String str) {
        String re = "^(?=.*[0-9])(?=.*[a-zA-Z])(?!.*\\W).{6,20}$";
        return str.matches(re);
    }

    public static String getFileNameByUrl(String url) {
        return url.substring(url.lastIndexOf("/"), url.length());
    }

    /**
     * 判断文件是否已经下载
     */
    public static boolean isFileExist(String url) {
        String fileName = getFileNameByUrl(url);
        String fullPath = getVedioFolder() + fileName;
        File file = new File(fullPath);
        return file.exists();
    }

    /**
     * vedio的存放文件夹
     */
    public static String getVedioFolder() {
        return Environment.getExternalStorageDirectory() + "/DancingVedio/";
    }

    public static String formatDuring(long time) {
        Date date = new Date(time);
        SimpleDateFormat aFormat = new SimpleDateFormat("HH:mm:ss");
        return aFormat.format(date);
    }


}

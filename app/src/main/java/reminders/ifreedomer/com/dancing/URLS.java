package reminders.ifreedomer.com.dancing;

import com.litesuits.common.utils.MD5Util;

import java.util.Map;

/**
 * Created by eavawu on 1/31/16.
 */
public class URLS {
    public static final String BASE_URL = "http://192.168.1.101:8080/";
    public static final String LOGIN_URL = BASE_URL + "login?";
    public static final String REGISTER_URL = BASE_URL + "register";
    public static final String HOT_LESSON_URL = BASE_URL + "lesson/getHotLesson?";
    public static final String GET_CHAPTERS_URL = BASE_URL + "chapter/getChapterByLessonId?";

    public static String getMethodParams(Map<String, String> params) {
        long time = System.currentTimeMillis();
        params.put(Constants.TIME_KEY, time + "");
//        params.put(Constants.ENCRYP_KEY, getMd5ByTime(time));
        //get封装请求参数
        String paramsStr = "";
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                paramsStr = entry.getKey().toString() + "=" + entry.getValue().toString() + "&" + paramsStr;
            }
        }
        return paramsStr;
    }

    public static String getMd5ByTime(long time) {
        String md5Result = new String(MD5Util.md5(time + Constants.SALT));
        return md5Result;
    }

    ;

    public static String getLoginUrl(Map<String, String> params) {
        return LOGIN_URL + getMethodParams(params);
    }

    ;

    public static String getHotLessonUrl(Map<String, String> params) {
        return HOT_LESSON_URL + getMethodParams(params);
    }

    ;

    public static String getChaptersUrl(Map<String, String> params) {
        return GET_CHAPTERS_URL + getMethodParams(params);
    }

}

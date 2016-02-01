package reminders.ifreedomer.com.dancing;

import java.util.Map;

/**
 * Created by eavawu on 1/31/16.
 */
public class URLS {
    public static final String BASE_URL = "http://192.168.1.102:8080/";
    public static final String LOGIN_URL = BASE_URL + "login?";
    public static final String REGISTER_URL = BASE_URL + "register";

    public static String getMethodParams(Map<String, String> params)  {
        //get封装请求参数
        String paramsStr = "";
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                paramsStr = entry.getKey().toString() +"="+ entry.getValue().toString()+"&"+paramsStr;
            }
        }
        return paramsStr;
    }
    public static String getLoginUrl(Map<String, String> params){
      return LOGIN_URL+getMethodParams(params);
    };
}

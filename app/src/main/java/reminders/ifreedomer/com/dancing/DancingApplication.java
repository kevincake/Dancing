package reminders.ifreedomer.com.dancing;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import cn.smssdk.SMSSDK;

/**
 * Created by eavawu on 2/21/16.
 */
public class DancingApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        SMSSDK.initSDK(this, Constants.appkey, Constants.appScret);
    }

}

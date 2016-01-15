package reminders.ifreedomer.com.dancing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class SplashActivity extends Activity {
    private Context m_context;
    private static final int JUMP_2_MAIN = 1;
    private int mSpashShowTime = 3000;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == JUMP_2_MAIN) {
                Intent mainIntent = new Intent(m_context, MainActivity.class);
                m_context.startActivity(mainIntent);
                finish();
            }
        }
    };

    @Override
    public void finish() {
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
        setContentView(R.layout.activity_splash);
        m_context = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(JUMP_2_MAIN);
            }
        }, mSpashShowTime);
    }

}

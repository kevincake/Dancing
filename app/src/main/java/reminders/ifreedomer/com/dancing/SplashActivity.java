package reminders.ifreedomer.com.dancing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.umeng.analytics.MobclickAgent;


public class SplashActivity extends BaseActivity {
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
        setContentView(R.layout.activity_splash);
        m_context = this;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(JUMP_2_MAIN);
            }
        }, mSpashShowTime);

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}

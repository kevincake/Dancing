package reminders.ifreedomer.com.dancing;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import reminders.ifreedomer.com.dancing.Bean.SMSVerifyBean;
import reminders.ifreedomer.com.dancing.customview.TitleView;

public class VerifyCodeActivity extends Activity implements View.OnClickListener {
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code);
        TitleView titleView = (TitleView) findViewById(R.id.title_view);
        titleView.setTitleText(getString(R.string.verify_text));
        titleView.setLeftButtonListener(this);
        EventHandler eventandler = new EventHandler(){
            @Override
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
                mHandler.sendMessage(msg);
            }
        };
        SMSSDK.registerEventHandler(eventandler);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.back_iv:
                this.finish();
                break;
            case R.id.commit_verfycode_btn:
                SMSSDK.submitVerificationCode(SMSVerifyBean.getContryCode(), SMSVerifyBean.getPhoneNum(),SMSVerifyBean.getVerifyCode());
                break;
        }
    }
}

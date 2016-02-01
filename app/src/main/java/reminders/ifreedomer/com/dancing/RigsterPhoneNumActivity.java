package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import reminders.ifreedomer.com.dancing.bean.SMSVerifyBean;


public class RigsterPhoneNumActivity extends AppCompatActivity implements View.OnClickListener {

    EditText phoneNumEt = null;
    TextView getCodeTv = null;
    TextView goLoginTv = null;
    Button registerBtn = null;
    EditText verifyCodeEt = null;
    Timer mTimer = new Timer();
    private int sub_time = 60;
    EventHandler eh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigster_phone_num);
        getCodeTv = (TextView) findViewById(R.id.getcode_tv);
        getCodeTv.setOnClickListener(this);
        phoneNumEt = (EditText) findViewById(R.id.phonenum_et);
        goLoginTv = (TextView) findViewById(R.id.go_login_tv);
        registerBtn = (Button) findViewById(R.id.register_btn);
        verifyCodeEt = (EditText) findViewById(R.id.verifycode_et);
        registerBtn.setOnClickListener(this);
        goLoginTv.setOnClickListener(this);

        eh = new EventHandler() {

            @Override
            public void afterEvent(int event, int result, Object data) {

                if (result == SMSSDK.RESULT_COMPLETE) {
                    //回调完成
                    if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                        //提交验证码成功
                        Intent intent = new Intent(RigsterPhoneNumActivity.this, FullUserInfoActivity.class);
                        startActivity(intent);
                    } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        //获取验证码成功
                    } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                        //返回支持发送验证码的国家列表
                    }
                } else {
                    Util.showWhiteToast(RigsterPhoneNumActivity.this, getString(R.string.verifycode_error), Toast.LENGTH_LONG);
                    ((Throwable) data).printStackTrace();
                }
            }
        };
        SMSSDK.registerEventHandler(eh); //注册短信回调
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private void beginTimer() {
        mTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {      // UI thread
                    @Override
                    public void run() {
                        sub_time--;
                        getCodeTv.setText(sub_time + "s");
                        if (sub_time < 0) {
                            getCodeTv.setText(getResources().getString(R.string.getcode_text));
                            mTimer.cancel();
                            getCodeTv.setClickable(true);
                            mTimer = null;
                            sub_time=60;
                        }
                    }
                });
            }
        };
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {

            case R.id.getcode_tv:
                if (!Util.isMobiPhoneNum(phoneNumEt.getText().toString())) {
                    Util.showWhiteToast(this, getResources().getString(R.string.phonenum_invalid), Toast.LENGTH_SHORT);
                    return;
                }
                SMSSDK.getVerificationCode(getString(R.string.contry_code), phoneNumEt.getText().toString());
                getCodeTv.setClickable(false);
                beginTimer();
                break;
            case R.id.go_login_tv:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.register_btn:
                //提交验证码成功
                SMSVerifyBean verifyBean = new SMSVerifyBean();
                verifyBean.setPhoneNum(phoneNumEt.getText().toString());
                Global.setmGlobalVerifyBean(verifyBean);
                if (!Util.isMobiPhoneNum(phoneNumEt.getText().toString())) {
                    Util.showWhiteToast(this, getResources().getString(R.string.phonenum_invalid), Toast.LENGTH_SHORT);
                    return;
                }
                if (verifyCodeEt.getText().toString().isEmpty()){
                    Util.showWhiteToast(this, getString(R.string.register_verifycode_notips), Toast.LENGTH_SHORT);
                    return;
                }
//                Intent intent1 = new Intent(this,FullUserInfoActivity.class);
//                startActivity(intent1);
                SMSSDK.submitVerificationCode(getString(R.string.contry_code), phoneNumEt.getText().toString(), verifyCodeEt.getText().toString());
                break;
            default:
                System.out.print("======" + id);
                break;

        }

    }

    @Override
    protected void onStop() {
        SMSSDK.unregisterAllEventHandler(); //注册短信回调
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_menu,menu);
//        MenuItem menuItem = menu.findItem(R.id.action_search);//在菜单中找到对应控件的item
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        return super.onCreateOptionsMenu(menu);
    }

}

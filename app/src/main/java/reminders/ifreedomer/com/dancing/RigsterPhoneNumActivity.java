package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import cn.smssdk.SMSSDK;


public class RigsterPhoneNumActivity extends AppCompatActivity implements View.OnClickListener {

    EditText phoneNumEt = null;
    TextView getCodeTv = null;
    TextView goLoginTv = null;
    Timer mTimer = new Timer();
    private int sub_time = 60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigster_phone_num);
        getCodeTv = (TextView) findViewById(R.id.getcode_tv);
        getCodeTv.setOnClickListener(this);
        phoneNumEt = (EditText) findViewById(R.id.phonenum_et);
        goLoginTv = (TextView) findViewById(R.id.go_login_tv);
        goLoginTv.setOnClickListener(this);
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
    private void beginTimer(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() {      // UI thread
                    @Override
                    public void run() {
                        sub_time--;
                        getCodeTv.setText(sub_time + "s");
                        if(sub_time < 0){
                            getCodeTv.setText(getResources().getString(R.string.getcode_text));
                            mTimer.cancel();
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
                if (Util.isMobiPhoneNum(phoneNumEt.getText().toString())) {
                    SMSSDK.getVerificationCode(getString(R.string.cn_phone_code), "18311362506");
                    beginTimer();
//                    Intent intent = new Intent(this, VerifyCodeActivity.class);
//                    startActivity(intent);
                } else
                    Toast.makeText(this, R.string.phonenum_invalid, Toast.LENGTH_SHORT);
                break;
            case R.id.go_login_tv:
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
            default:
                System.out.print("======"+id);
                break;

        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.search_menu,menu);
//        MenuItem menuItem = menu.findItem(R.id.action_search);//在菜单中找到对应控件的item
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        return super.onCreateOptionsMenu(menu);
    }

}

package reminders.ifreedomer.com.dancing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.smssdk.SMSSDK;


public class RigsterPhoneNumActivity extends Activity implements View.OnClickListener {

    EditText phoneNumEt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigster_phone_num);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rigster_phone_num, menu);
        return true;
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.back_iv:
                this.finish();
                break;
            case R.id.getcode_btn:
                if (Util.isMobiPhoneNum(phoneNumEt.getText().toString())) {
                    SMSSDK.getVerificationCode("+86", "18311362506");
                    Intent intent = new Intent(this, VerifyCodeActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(this, R.string.phonenum_invalid, Toast.LENGTH_SHORT);
                break;
        }
    }
}

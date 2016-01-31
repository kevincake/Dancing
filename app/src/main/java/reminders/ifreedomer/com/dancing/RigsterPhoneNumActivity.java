package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cn.smssdk.SMSSDK;


public class RigsterPhoneNumActivity extends AppCompatActivity implements View.OnClickListener {

    EditText phoneNumEt = null;
    Button getCodeBtn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rigster_phone_num);
        getCodeBtn = (Button) findViewById(R.id.getcode_btn);
        getCodeBtn.setOnClickListener(this);
        phoneNumEt = (EditText) findViewById(R.id.phonenum_et);
        setUpToolBar();
    }

    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.phone_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        TextView centerTv = (TextView) toolbar.findViewById(R.id.center_tv);
        centerTv.setText(getString(R.string.register_title));
        this.setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        toolbar.setNavigationIcon(R.mipmap.back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RigsterPhoneNumActivity.this.finish();
            }
        });
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

            case R.id.getcode_btn:
                if (Util.isMobiPhoneNum(phoneNumEt.getText().toString())) {
                    SMSSDK.getVerificationCode(getString(R.string.cn_phone_code), "18311362506");
                    Intent intent = new Intent(this, VerifyCodeActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(this, R.string.phonenum_invalid, Toast.LENGTH_SHORT);
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

package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    Button mLoginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
        setUpToolBar();
    }


    private void setUpToolBar() {
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.login_toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
//        toolbar.setCenterTitle(getString(R.string.register_title));
        this.setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        toolbar.setNavigationIcon(R.mipmap.back);
        TextView centerTv = (TextView) toolbar.findViewById(R.id.center_tv);
//        centerTv.setText(R.string.login_title);
        centerTv.setText(getString(R.string.login_title));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.this.finish();
            }
        });
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.login_btn:
                Intent intent = new Intent(this, HomePageActivity.class);
                startActivity(intent);
                break;
            case R.id.back_iv:
                this.finish();
                break;
        }

    }
}

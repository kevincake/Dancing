package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import reminders.ifreedomer.com.dancing.customview.TitleView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button mLoginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
        TitleView titleView = (TitleView) findViewById(R.id.title_view);
        titleView.setLeftButtonListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.login_btn:
                Intent intent = new Intent(this,HomePageActivity.class);
                startActivity(intent);
                break;
            case R.id.back_iv:
                this.finish();
                break;
        }

    }
}

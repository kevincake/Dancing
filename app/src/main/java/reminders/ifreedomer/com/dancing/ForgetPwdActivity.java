package reminders.ifreedomer.com.dancing;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import cn.smssdk.SMSSDK;

public class ForgetPwdActivity extends BaseActivity implements View.OnClickListener {
    EditText phoneNumEt;
    EditText verifyCodeEt;
    EditText pwdEt;
    EditText repwdEt;
    Button commitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pwd);
        phoneNumEt = (EditText) findViewById(R.id.phonenum_et);
        verifyCodeEt = (EditText) findViewById(R.id.verifycode_et);
        pwdEt = (EditText) findViewById(R.id.forget_pwd_tv);
        repwdEt = (EditText) findViewById(R.id.forget_repwd_tv);
        commitBtn = (Button) findViewById(R.id.forget_commit_tv);
        commitBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget_commit_tv:
                SMSSDK.getVerificationCode(getString(R.string.contry_code), phoneNumEt.getText().toString());
                break;
        }

    }
}

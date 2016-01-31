package reminders.ifreedomer.com.dancing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import reminders.ifreedomer.com.dancing.bean.User;

public class LoginActivity extends Activity implements View.OnClickListener {
    Button mLoginBtn;
    EditText phoneEt;
    EditText pwdEt;
    AVLoadingIndicatorView loadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginBtn = (Button) findViewById(R.id.login_btn);
        mLoginBtn.setOnClickListener(this);
        phoneEt = (EditText) findViewById(R.id.phonenum_et);
        pwdEt = (EditText) findViewById(R.id.pwd_et);
        loadingView = (AVLoadingIndicatorView) findViewById(R.id.avloadingIndicatorView);
//        setUpToolBar();
    }


    private void setUpToolBar() {
//        Toolbar toolbar = (Toolbar) this.findViewById(R.id.login_toolbar);
//        toolbar.setTitleTextColor(Color.WHITE);
////        toolbar.setCenterTitle(getString(R.string.register_title));
//        this.setSupportActionBar(toolbar);
//        ActionBar supportActionBar = getSupportActionBar();
//        toolbar.setNavigationIcon(R.mipmap.back);
//        TextView centerTv = (TextView) toolbar.findViewById(R.id.center_tv);
////        centerTv.setText(R.string.login_title);
//        centerTv.setText(getString(R.string.login_title));
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LoginActivity.this.finish();
//            }
//        });
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.login_btn:
                AsyncHttpClient client = new AsyncHttpClient();
                Map<String, String> map = new HashMap<String, String>();
                map.put("account", phoneEt.getText().toString().trim());
                map.put("password", pwdEt.getText().toString().trim());
                loadingView.setVisibility(View.VISIBLE);
                String loginUrl = URLS.getLoginUrl(map);
                Log.e("wuyihua=====",loginUrl);
                RequestHandle requestHandle = client.get(loginUrl, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(new String(responseBody));
                            int resultCode = obj.getInt("result");
                            if (resultCode == Constants.OK) {
                                Gson gson = new Gson();
                                Global.setmGlobalUser(gson.fromJson(obj.getString("data"), User.class));
                                Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                                startActivity(intent);
                            } else {
                                Util.showWhiteToast(LoginActivity.this,obj.getString("errno"),Toast.LENGTH_SHORT);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        } finally {
                            loadingView.setVisibility(View.GONE);
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        Util.showWhiteToast(LoginActivity.this,getResources().getString(R.string.login_failed),Toast.LENGTH_SHORT);
//                        Toast toast = Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_failed), Toast.LENGTH_SHORT);

                        loadingView.setVisibility(View.GONE);
                    }
                });

                break;
            case R.id.back_iv:
                this.finish();
                break;
        }

    }
}

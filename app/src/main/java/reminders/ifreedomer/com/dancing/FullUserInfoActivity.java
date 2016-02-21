package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import cn.qqtheme.framework.picker.NumberPicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.smssdk.SMSSDK;
import cz.msebera.android.httpclient.Header;
import de.hdodenhof.circleimageview.CircleImageView;
import reminders.ifreedomer.com.dancing.bean.User;

public class FullUserInfoActivity extends BaseActivity implements View.OnClickListener {
    private TextView back2RegisterTv;
    private EditText userNameEt;
    private EditText pwdEt;
    private TextView yearOldTv;
    private TextView sexTv;
    private Button commitInfoBtn;
    private CircleImageView userHeadIv;
    private AVLoadingIndicatorView loadingIndicatorView;
    private static final int PICK_PHOTO_FOR_AVATAR = 1024;
    private static final int TAKE_PHOTO_FOR_AVATAR = 110;
    InputStream inputStream = null;
    private File uploadFile;
    Uri originalUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_userinfo);
        back2RegisterTv = (TextView) findViewById(R.id.fullinfo_back2register_tv);
        userNameEt = (EditText) findViewById(R.id.fullinfo_username_et);
        pwdEt = (EditText) findViewById(R.id.fullinfo_pwd_et);
        yearOldTv = (TextView) findViewById(R.id.fullinfo_yearsold_tv);
        sexTv = (TextView) findViewById(R.id.fullinfo_sex_tv);
        commitInfoBtn = (Button) findViewById(R.id.fullinfo_commit_btn);
        userHeadIv = (CircleImageView) findViewById(R.id.fullinfo_userhead_iv);
        loadingIndicatorView = (AVLoadingIndicatorView) findViewById(R.id.avloadingIndicatorView);
        userHeadIv.setOnClickListener(this);
        sexTv.setOnClickListener(this);
        commitInfoBtn.setOnClickListener(this);
        back2RegisterTv.setOnClickListener(this);
        yearOldTv.setOnClickListener(this);
        uploadFile = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");

    }

    private void selectPhotoFromGallery() {
        // Create intent for picking a photo from the gallery
        SMSSDK.initSDK(this, Constants.appkey, Constants.appScret);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_PHOTO_FOR_AVATAR);
    }

    private void getPhotoFromCamera() {
        // 调用相机
        Intent mIntent = new Intent("android.media.action.IMAGE_CAPTURE");
        // 图片存储路径，可自定义
//        File tmpFile = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
        // 获取这个图片的URI

        originalUri = Uri.fromFile(uploadFile);//这是个实例变量，方便下面获取图片的时候用
        mIntent.putExtra(MediaStore.EXTRA_OUTPUT, originalUri);
        startActivityForResult(mIntent, TAKE_PHOTO_FOR_AVATAR);
    }

    private void inputStream2File(InputStream ins, File file) {
//        File file = new File(path);
        OutputStream outputStream = null;
        try {

            outputStream = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] bytes = new byte[1024];
            int read = 0;
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.close();
//            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        ;


        switch (requestCode) {
            case PICK_PHOTO_FOR_AVATAR:

                if (data == null) return;
                try {
                    originalUri = data.getData();
                    inputStream = getContentResolver().openInputStream(data.getData());
                    inputStream2File(inputStream, uploadFile);
                    String path = uploadFile.getPath();
                    userHeadIv.setImageBitmap(BitmapFactory.decodeFile(uploadFile.getPath()));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case TAKE_PHOTO_FOR_AVATAR:
                try {
                    inputStream = (FileInputStream) getContentResolver().openInputStream(Uri.parse(originalUri.toString()));
                    inputStream2File(inputStream, uploadFile);
                    userHeadIv.setImageBitmap(BitmapFactory.decodeFile(uploadFile.getPath()));

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:

                break;

        }
//        if (requestCode==PICK_PHOTO_FOR_AVATAR){}

//        if (requestCode == PICK_PHOTO_FOR_AVATAR && resultCode == Activity.RESULT_OK) {
//            if (data == null) {
//                //Display an error
//                return;
//            }
//            try {
//                InputStream inputStream = getContentResolver().openInputStream(data.getData());
//                userHeadIv.setImageBitmap(BitmapFactory.decodeStream(inputStream));
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
        //Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fullinfo_yearsold_tv:
                NumberPicker yearOldPicker = new NumberPicker(this);
                yearOldPicker.setOffset(2);//偏移量
                yearOldPicker.setRange(1, 120);//数字范围
                yearOldPicker.setSelectedItem(1);
                yearOldPicker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(String option) {
                        yearOldTv.setText(option);
                    }
                });
                yearOldPicker.show();
                break;
            case R.id.fullinfo_userhead_iv:
                OptionPicker photoPicker = new OptionPicker(this, new String[]{
                        "拍照", "从相册选择"
                });
                photoPicker.setOffset(2);
                photoPicker.setSelectedIndex(1);
                photoPicker.setTextSize(11);
                photoPicker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(String option) {
//                        if(option.equals("")){}
                        if (option.equals("拍照")) {
                            getPhotoFromCamera();
                        } else {
                            selectPhotoFromGallery();
                        }
//                        sexTv.setText(option);
//                        Util.showWhiteToast(FullUserInfoActivity.this, option, Toast.LENGTH_LONG);
//                        showToast(option);
                    }
                });
                photoPicker.show();
                break;
            case R.id.fullinfo_back2register_tv:
                Intent intent = new Intent(this, RigsterPhoneNumActivity.class);
                startActivity(intent);
                break;
            case R.id.fullinfo_sex_tv:
                OptionPicker picker = new OptionPicker(this, new String[]{
                        "男", "女"
                });
                picker.setOffset(2);
                picker.setSelectedIndex(1);
                picker.setTextSize(11);
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(String option) {
                        sexTv.setText(option);
//                        Util.showWhiteToast(FullUserInfoActivity.this, option, Toast.LENGTH_LONG);
//                        showToast(option);
                    }
                });
                picker.show();
                break;
            case R.id.fullinfo_commit_btn:
                if (!Util.isPassword(pwdEt.getText().toString())) {
                    Util.showWhiteToast(FullUserInfoActivity.this, getString(R.string.info_password_invalid), Toast.LENGTH_LONG);
                    return;
                }
                if (sexTv.getText().toString().isEmpty()) {
                    Util.showWhiteToast(FullUserInfoActivity.this, getString(R.string.info_sex_tips), Toast.LENGTH_LONG);
                    return;
                }
                if (userNameEt.getText().toString().isEmpty()) {
                    Util.showWhiteToast(FullUserInfoActivity.this, getString(R.string.info_nousername_tips), Toast.LENGTH_LONG);
                    return;
                }
                if (uploadFile.length() <= 0) {
                    Util.showWhiteToast(FullUserInfoActivity.this, "让我看到你帅气的脸,去选张照片吧", Toast.LENGTH_LONG);
                    return;
                }
                AsyncHttpClient client = new AsyncHttpClient();
                RequestParams params = new RequestParams();
                params.put(Constants.ACCOUNT_KEY, Global.getmGlobalVerifyBean().getPhoneNum());
                params.put(Constants.BIRTHDAY_KEY, yearOldTv.getText().toString());
                params.put(Constants.PASSWORLD_KEY, pwdEt.getText().toString());
                params.put(Constants.SEX_KEY, ((sexTv.getText().toString().equals("女")) ? 0 : 1) + "");
                params.put(Constants.USERNAME_KEY, userNameEt.getText().toString());
                try {

//                    Uri path = Uri.parse(originalUri.toString());
//                    String path = originalUri.getPath();
//                    File file = new File(inputStream);
//                    String path = inputStream2File();
//                    File tmpFile = new File(Environment.getExternalStorageDirectory(), System.currentTimeMillis() + ".jpg");
//                    inputStream2File(inputStream,tmpFile);
                    params.put(Constants.HEADIMG_KEY, uploadFile);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                loadingIndicatorView.setVisibility(View.VISIBLE);
//                params.put(Constants.HEADIMG_KEY, BitmapFactory.decodeResource())
                client.post(URLS.REGISTER_URL, params, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        loadingIndicatorView.setVisibility(View.INVISIBLE);
                        JSONObject obj = null;
                        try {
                            obj = new JSONObject(new String(responseBody));
                            int resultCode = obj.getInt("result");
                            if (resultCode == Constants.OK) {
                                Gson gson = new Gson();
                                Global.setmGlobalUser(gson.fromJson(obj.getString("data"), User.class));
                                Intent intent = new Intent(FullUserInfoActivity.this, LoginActivity.class);
                                startActivity(intent);
                            } else {
                                Util.showWhiteToast(FullUserInfoActivity.this, obj.getString("errno"), Toast.LENGTH_SHORT);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                        loadingIndicatorView.setVisibility(View.INVISIBLE);
                    }
                });
                break;
        }
    }
}

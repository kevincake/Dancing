package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cz.msebera.android.httpclient.Header;
import reminders.ifreedomer.com.dancing.adapter.DancingPlanAdapter;
import reminders.ifreedomer.com.dancing.bean.Chapter;

public class DancingPlanActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    ListView mDancingPlanLv;
    AVLoadingIndicatorView loadingView;
    ArrayList<Chapter> chapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dancing_plan);
        loadingView = (AVLoadingIndicatorView) findViewById(R.id.avloadingIndicatorView);
        mDancingPlanLv = (ListView) findViewById(R.id.dancing_plan_lv);
//        mDancingPlanLv.setAdapter(new DancingPlanAdapter(this));
        mDancingPlanLv.setOnItemClickListener(this);
        mDancingPlanLv.addHeaderView(View.inflate(this, R.layout.lv_dancingplan_header_item, null));
        requestData();
    }

    private void requestData() {
        AsyncHttpClient client = new AsyncHttpClient();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.LESSON_ID, Global.getmLesson().getId() + "");


        String getChapterUrl = URLS.getChaptersUrl(map);
        Log.e("=====requestSetData====", getChapterUrl);
        RequestHandle requestHandle = client.get(getChapterUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONObject obj = null;
                try {
                    obj = new JSONObject(new String(responseBody));
                    int resultCode = obj.getInt("result");
                    if (resultCode == Constants.OK) {
                        Gson gson = new Gson();
                        Type listType = new TypeToken<ArrayList<Chapter>>() {
                        }.getType();
                        chapters = new Gson().fromJson(obj.getString("data"), listType);
                        mDancingPlanLv.setAdapter(new DancingPlanAdapter(DancingPlanActivity.this, chapters));
                    } else {
                        Util.showWhiteToast(DancingPlanActivity.this, obj.getString("errno"), Toast.LENGTH_SHORT);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    loadingView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Util.showWhiteToast(DancingPlanActivity.this, getResources().getString(R.string.login_failed), Toast.LENGTH_SHORT);
//                        Toast toast = Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_failed), Toast.LENGTH_SHORT);

                loadingView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) return;
        Intent intent = new Intent(this, MediaPlayerActivity.class);
        intent.putExtra(Constants.VIDEO_URL, chapters.get(position).getVideo());
        startActivity(intent);
//        MD5Util.md5()
    }
}

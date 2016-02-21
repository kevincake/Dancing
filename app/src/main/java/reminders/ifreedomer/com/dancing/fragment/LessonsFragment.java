package reminders.ifreedomer.com.dancing.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import reminders.ifreedomer.com.dancing.Constants;
import reminders.ifreedomer.com.dancing.DancingPlanActivity;
import reminders.ifreedomer.com.dancing.Global;
import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.URLS;
import reminders.ifreedomer.com.dancing.Util;
import reminders.ifreedomer.com.dancing.adapter.LessonsAdapter;
import reminders.ifreedomer.com.dancing.bean.Lesson;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonsFragment extends Fragment implements AdapterView.OnItemClickListener {

    AVLoadingIndicatorView loadingView;
    private ListView contentLv;
    ArrayList<Lesson> lessons;

    public LessonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lessons, container, false);
        contentLv = (ListView) view.findViewById(R.id.lessons_lv);
        contentLv.setOnItemClickListener(this);
        loadingView = (AVLoadingIndicatorView) view.findViewById(R.id.avloadingIndicatorView);
        initListView(contentLv);
        requestSetData();
        return view;
    }

    private void test() {
        ArrayList<Lesson> lessons = new ArrayList<>();

        contentLv.setAdapter(new LessonsAdapter(getActivity(), lessons));
    }

    private void requestSetData() {
        AsyncHttpClient client = new AsyncHttpClient();
        Map<String, String> map = new HashMap<>();
        map.put(Constants.PAGENUM_KEY, 0 + "");
        map.put(Constants.PAGESIZE_KEY, Constants.PAGESIZE + "");

        String hotLessonUrl = URLS.getHotLessonUrl(map);
        Log.e("=====requestSetData====", hotLessonUrl);
        RequestHandle requestHandle = client.get(hotLessonUrl, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONObject obj = null;
                try {
                    obj = new JSONObject(new String(responseBody));
                    int resultCode = obj.getInt("result");
                    if (resultCode == Constants.OK) {
                        Gson gson = new Gson();
                        Type listType = new TypeToken<ArrayList<Lesson>>() {
                        }.getType();
                        lessons = new Gson().fromJson(obj.getString("data"), listType);
                        contentLv.setAdapter(new LessonsAdapter(getActivity(), lessons));
                    } else {
                        Util.showWhiteToast(getActivity(), obj.getString("errno"), Toast.LENGTH_SHORT);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    loadingView.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Util.showWhiteToast(getActivity(), getResources().getString(R.string.login_failed), Toast.LENGTH_SHORT);
//                        Toast toast = Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_failed), Toast.LENGTH_SHORT);

                loadingView.setVisibility(View.GONE);
            }
        });
    }

    private void initListView(ListView contentLv) {
        ArrayList<Lesson> contents = new ArrayList<Lesson>();
        contentLv.setAdapter(new LessonsAdapter(getActivity(), contents));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Global.setmLesson(lessons.get(position));
        Intent intent = new Intent(this.getActivity(), DancingPlanActivity.class);
        startActivity(intent);
    }
}

package reminders.ifreedomer.com.dancing;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import reminders.ifreedomer.com.dancing.adapter.GenericAdapter;
import reminders.ifreedomer.com.dancing.listener.MainPageListener;


public class MainActivity extends BaseActivity implements View.OnClickListener {
    String TAG = "reminders.ifreedomer.com.dancing";
    private VideoView mVideoView = null;
    private ViewPager mViewPager = null;
    private TextView registerBtn = null;
    private TextView loginBtn = null;
    ArrayList<ImageView> dots = null;
    int mPageIndex = 0;
    public static final int MAX_PAGE = 4;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mPageIndex >= MAX_PAGE - 1) {
                mPageIndex = 0;
            } else if (mPageIndex < MAX_PAGE) {
                mPageIndex = mViewPager.getCurrentItem() + 1;
            }
            mViewPager.setCurrentItem(mPageIndex);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setVideoViewFullScreen();
        initVideoView();
        addAllDots2List();
        initViewPager();
        autoScrollViewPager();
        initAllListener();
    }

    private void initView() {
        mVideoView = (VideoView) this.findViewById(R.id.bg_videoview);
        mViewPager = (ViewPager) this.findViewById(R.id.ad_page);
        registerBtn = (TextView) this.findViewById(R.id.register_btn);
        loginBtn = (TextView) this.findViewById(R.id.login_btn);
    }

    private void initAllListener() {
        registerBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);

    }
    void  setVideoViewFullScreen(){
        DisplayMetrics metrics = new DisplayMetrics(); getWindowManager().getDefaultDisplay().getMetrics(metrics);
        android.widget.RelativeLayout.LayoutParams params = (android.widget.RelativeLayout.LayoutParams) mVideoView.getLayoutParams();
        params.width =  metrics.widthPixels;
        params.height = metrics.heightPixels;
        params.leftMargin = 0;
        mVideoView.setLayoutParams(params);
    }

    void initVideoView() {

        final String videopath = "android.resource://" + this.getPackageName() + "/" + R.raw.intro;
        mVideoView.setVideoURI(Uri.parse(videopath));
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mVideoView.setVideoPath(videopath);
                mVideoView.start();

            }
        });
        mVideoView.start();
    }

    void autoScrollViewPager() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(1);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 3000, 3000);
    }

    void addAllDots2List() {
        dots = new ArrayList<>();
        ImageView dot1 = (ImageView) this.findViewById(R.id.dot1);
        ImageView dot2 = (ImageView) this.findViewById(R.id.dot2);
        ImageView dot3 = (ImageView) this.findViewById(R.id.dot3);
        ImageView dot4 = (ImageView) this.findViewById(R.id.dot4);
        dots.add(dot1);
        dots.add(dot2);
        dots.add(dot3);
        dots.add(dot4);
    }

    void initViewPager() {

        ArrayList<View> views = new ArrayList<View>();
        for (int i = 0; i < MAX_PAGE; i++) {
            views.add(View.inflate(this, R.layout.page_item_4main, null));
            TextView tv = (TextView) views.get(i).findViewById(R.id.power_text);
            tv.setText(getString(R.string.main_des1 + i));
        }
        mViewPager.setAdapter(new GenericAdapter(views));
        mViewPager.setOnPageChangeListener(new MainPageListener(dots));
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mVideoView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
        if (id == R.id.register_btn) {
            Log.e(TAG, "jinru");
            MobclickAgent.onEvent(this,Constants.UM_REGISTER_ID);
            Intent register = new Intent(this, RigsterPhoneNumActivity.class);
            startActivity(register);
        } else if (id == R.id.login_btn) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}

package reminders.ifreedomer.com.dancing;

import android.app.Activity;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.VideoView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.adapter.GenericAdapter;


public class MainActivity extends Activity {
    private VideoView mVideoView = null;
    private ViewPager mViewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) this.findViewById(R.id.bg_videoview);
        mViewPager = (ViewPager) this.findViewById(R.id.ad_page);
        mVideoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() + "/" + R.raw.intro));
        mVideoView.start();
    }

    void initViewPager() {

        ArrayList<View> views = new ArrayList<View>();

        mViewPager.setAdapter(new GenericAdapter(views));
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
}

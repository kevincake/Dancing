package reminders.ifreedomer.com.dancing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;

import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {
    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tb = (Toolbar) findViewById(R.id.test_toolbar);
        this.setSupportActionBar(tb);
        ObservableListView listView = (ObservableListView) findViewById(R.id.list);
        listView.setScrollViewCallbacks(this);
        // Add these codes after ListView initialization
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            items.add("Item " + i);
        }
        listView.setAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {

    }

    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        android.support.v7.app.ActionBar ab = this.getSupportActionBar();
        if (scrollState == ScrollState.UP) {
            if (ab.isShowing()) {

            }
        } else if (scrollState == ScrollState.DOWN) {
            if (!ab.isShowing()) {
                ab.show();
            }
        }
    }
}

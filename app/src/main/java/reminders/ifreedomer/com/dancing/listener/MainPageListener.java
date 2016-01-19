package reminders.ifreedomer.com.dancing.listener;

import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;

/**
 * Created by eavawu on 1/16/16.
 */
public class MainPageListener implements ViewPager.OnPageChangeListener {
    private ArrayList<ImageView> dots = null;

    public MainPageListener(ArrayList<ImageView> dots) {
        this.dots = dots;
        this.dots.get(0).setImageResource(R.mipmap.dot_green);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dots.size(); i++) {
            dots.get(i).setImageResource(R.mipmap.dot);
        }
        this.dots.get(position).setImageResource(R.mipmap.dot_green);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

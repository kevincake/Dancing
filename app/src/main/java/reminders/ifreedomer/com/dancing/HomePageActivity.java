package reminders.ifreedomer.com.dancing;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import reminders.ifreedomer.com.dancing.fragment.LessonsFragment;
import reminders.ifreedomer.com.dancing.fragment.PersonalCenterFragment;
import reminders.ifreedomer.com.dancing.fragment.SocialFragment;

/**
 * Created by neokree on 30/12/14.
 */
public class HomePageActivity extends AppCompatActivity implements MaterialTabListener {
    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    MaterialTabHost tabHost;
    private Resources res;
    private ArrayList<Fragment> fragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        res = this.getResources();
        // init toolbar (old action bar)
        initFraments();
        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        this.setSupportActionBar(toolbar);

        tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);

        pager = (ViewPager) this.findViewById(R.id.pager);
        // init view pager
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });
        // insert all tabs from pagerAdapter data
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(getIcon(i))
                            .setTabListener(this)
            );
        }
    }
    private void initFraments(){
        fragments = new ArrayList<Fragment>();
        fragments.add(new LessonsFragment());
        fragments.add(new SocialFragment());
        fragments.add(new PersonalCenterFragment());

    }
    @Override
    public void onTabSelected(MaterialTab tab) {
// when the tab is clicked the pager swipe content to the tab position
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {
    }

    @Override
    public void onTabUnselected(MaterialTab tab) {
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public Fragment getItem(int num) {
            return fragments.get(num);
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
        @Override
        public CharSequence getPageTitle(int position) {
            switch(position) {
                case 0: return "tab 1";
                case 1: return "tab 2";
                case 2: return "tab 3";
                default: return null;
            }
        }
    }
    /*
    * It doesn't matter the color of the icons, but they must have solid colors
    */
    private Drawable getIcon(int position) {
        switch(position) {
            case 0:
                return res.getDrawable(R.mipmap.ic_menu);
            case 1:
                return res.getDrawable(R.mipmap.ic_earth);
            case 2:
                return res.getDrawable(R.mipmap.ic_person_center);
        }
        return null;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);//在菜单中找到对应控件的item
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        return super.onCreateOptionsMenu(menu);
    }

}
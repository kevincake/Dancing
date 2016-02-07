package reminders.ifreedomer.com.dancing.fragment;


import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import reminders.ifreedomer.com.dancing.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalCenterFragment extends Fragment implements MaterialTabListener {

    ArrayList<Fragment> fragments;
    private Resources res;
    ViewPager pager;
    PersonViewPagerAdapter pagerAdapter;

    public PersonalCenterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_person_center, container, false);
        CircleImageView headerIv = (CircleImageView) view.findViewById(R.id.head_iv);
        final MaterialTabHost tabHost = (MaterialTabHost) view.findViewById(R.id.content_tbhost);
        pager = (ViewPager) view.findViewById(R.id.person_viewpager);
        // init view pager
        initFraments();

        PersonViewPagerAdapter pagerAdapter = new PersonViewPagerAdapter(getChildFragmentManager());
        pager.setAdapter(pagerAdapter);
        res = getResources();
//        pager.setFocusableInTouchMode(false);
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
                            .setText(pagerAdapter.getPageTitle(i))
                            .setTabListener(this)
            );
        }

        ImageLoader loader = ImageLoader.getInstance();
//        String url = Global.getmGlobalUser().getHeadIcon();
//        loader.displayImage(url, headerIv);

        return view;
    }

    private void initFraments() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new FollowerFragment());
        fragments.add(new FollowingFragment());
        fragments.add(new FollowerFragment());
    }

    private class setAdapterTask extends AsyncTask<Void, Void, Void> {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            pager.setAdapter(pagerAdapter);
        }
    }

    private class PersonViewPagerAdapter extends FragmentPagerAdapter {
        public PersonViewPagerAdapter(FragmentManager fm) {
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
            switch (position) {
                case 0:
                    return "Vedio";
                case 1:
                    return "Follower";
                case 2:
                    return "Following";
                default:
                    return null;
            }
        }


    }

    @Override
    public void onTabSelected(MaterialTab tab) {
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabReselected(MaterialTab tab) {

    }

    @Override
    public void onTabUnselected(MaterialTab tab) {

    }
}

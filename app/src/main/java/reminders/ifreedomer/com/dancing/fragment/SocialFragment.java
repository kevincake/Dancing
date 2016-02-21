package reminders.ifreedomer.com.dancing.fragment;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;
import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.adapter.SocialLvAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SocialFragment extends Fragment implements MaterialTabListener {
    ArrayList<Fragment> fragments;
    private Resources res;
    ViewPager pager;
    SocialFragmentAdapter pagerAdapter;
    View view;

    public SocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_social, container, false);
        initFraments();
        initTab();

//        ListView contentLv = (ListView) view.findViewById(R.id.social_lv);
//        initListView(contentLv);
        return view;
    }

    private void initListView(ListView listView) {
        listView.setAdapter(new SocialLvAdapter(getActivity(), new ArrayList()));

    }

    private void initFraments() {
        fragments = new ArrayList<Fragment>();
        fragments.add(new FollowerFragment());
        fragments.add(new FollowingFragment());
        fragments.add(new NewestFragment());
        fragments.add(new NewestFragment());
//        fragments.add(new NewestFragment());
    }

    private void initTab() {
        final MaterialTabHost tabHost = (MaterialTabHost) view.findViewById(R.id.content_tbhost);
        tabHost.setPadding(150,0,150,0);
//        tabHost.setMinimumWidth(getActivity().getWindowManager().getDefaultDisplay().getWidth());
        pager = (ViewPager) view.findViewById(R.id.person_viewpager);
        // init view pager
        initFraments();

        SocialFragmentAdapter pagerAdapter = new SocialFragmentAdapter(getChildFragmentManager());
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

    private class SocialFragmentAdapter extends FragmentPagerAdapter {
        public SocialFragmentAdapter(FragmentManager fm) {
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
                    return getActivity().getString(R.string.discover);
                case 1:
                    return getActivity().getString(R.string.careful); 
                case 2:
                    return getActivity().getString(R.string.newest); 
                case 3:
                    return getActivity().getString(R.string.friend);
                default:
                    return getActivity().getString(R.string.friend);
            }
        }


    }

}

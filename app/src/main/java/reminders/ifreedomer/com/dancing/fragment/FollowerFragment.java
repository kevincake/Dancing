package reminders.ifreedomer.com.dancing.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.adapter.FollowerAdapter;
import reminders.ifreedomer.com.dancing.bean.Follower;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowerFragment extends Fragment {


    public FollowerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_follower, container, false);
        ListView followerLv = (ListView) view.findViewById(R.id.follower_lv);
        initListView(followerLv);
        return view;
    }
    private void initListView(ListView contentLv) {
        ArrayList<Follower> contents = new ArrayList<Follower>();
        contentLv.setAdapter(new FollowerAdapter(1,getActivity(),contents));
    }

}

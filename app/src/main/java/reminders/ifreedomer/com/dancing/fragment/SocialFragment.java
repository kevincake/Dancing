package reminders.ifreedomer.com.dancing.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.adapter.SocialLvAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class SocialFragment extends Fragment {


    public SocialFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_social,container,false);
        ListView contentLv = (ListView) view.findViewById(R.id.social_lv);
        initListView(contentLv);
        return view;
    }
    private void initListView(ListView listView){
        listView.setAdapter(new SocialLvAdapter(getActivity(),new ArrayList()));

    }
}

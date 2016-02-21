package reminders.ifreedomer.com.dancing.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.adapter.SocialLvAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewestFragment extends Fragment {


    private View view;
    private ListView newestLv;

    public NewestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_newest, container, false);
        newestLv = (ListView) view.findViewById(R.id.newest_lv);
        newestLv.setAdapter(new SocialLvAdapter(getActivity(),null));

        return view;
    }

}

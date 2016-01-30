package reminders.ifreedomer.com.dancing.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.adapter.LessonsAdapter;
import reminders.ifreedomer.com.dancing.bean.Lesson;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonsFragment extends Fragment {


    public LessonsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lessons,container,false);
        ListView contentLv = (ListView) view.findViewById(R.id.lessons_lv);
        initListView(contentLv);
        return view;
    }

    private void initListView(ListView contentLv) {
        ArrayList<Lesson> contents = new ArrayList<Lesson>();
        contentLv.setAdapter(new LessonsAdapter(getActivity(),contents));
    }

}
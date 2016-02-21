package reminders.ifreedomer.com.dancing.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.adapter.MasonryAdapter;
import reminders.ifreedomer.com.dancing.adapter.ReViewMsg;
import reminders.ifreedomer.com.dancing.customview.SpacesItemDecoration;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment {


    private View view;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_discover, container, false);
        initRecycleView();
        ;
        return view;
    }

    private void initRecycleView() {
        RecyclerView recycleView = (RecyclerView) view.findViewById(R.id.discover_recycleview);
        //设置layoutManager
        recycleView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置adapter
//        initData();
        ArrayList<ReViewMsg> msgs = new ArrayList<>();

        for (int i=0;i<20;i++){
            ReViewMsg msg = new ReViewMsg();
            msgs.add(msg);
        }
        MasonryAdapter adapter=new MasonryAdapter(msgs);
        recycleView.setAdapter(adapter);
        //设置item之间的间隔
        SpacesItemDecoration decoration=new SpacesItemDecoration(16);
        recycleView.addItemDecoration(decoration);
    }


}

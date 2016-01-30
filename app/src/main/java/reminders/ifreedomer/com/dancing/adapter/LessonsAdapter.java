package reminders.ifreedomer.com.dancing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.bean.Lesson;

/**
 * Created by eavawu on 1/30/16.
 */
public class LessonsAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Lesson> mContents;
    public LessonsAdapter(Context context, ArrayList<Lesson> contents) {
        mContext = context;
        mContents = contents;

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext,R.layout.lv_lesson_item, null);
        return view;
    }
}

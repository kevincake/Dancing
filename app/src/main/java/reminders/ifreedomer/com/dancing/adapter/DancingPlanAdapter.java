package reminders.ifreedomer.com.dancing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.bean.Chapter;

/**
 * Created by eavawu on 2/3/16.
 */
public class DancingPlanAdapter extends BaseAdapter {
    private Context mCtx;
    ArrayList<Chapter> mChapters;
    public static final int Headtype = 1;
    public static final int CONTENTTYPE = 2;

    public DancingPlanAdapter(Context ctx, ArrayList<Chapter> chapters) {
        mCtx = ctx;
        mChapters = chapters;
    }


    @Override
    public int getCount() {
        return mChapters.size();
    }

    @Override
    public Object getItem(int position) {
        return mChapters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mCtx, R.layout.lv_dancingplan_item, null);
            holder = new ViewHolder();
            holder.nameTv = (TextView) convertView.findViewById(R.id.dancingplan_name_tv);
            holder.timeTv = (TextView) convertView.findViewById(R.id.dancingplan_time_tv);
            holder.orderTv = (TextView) convertView.findViewById(R.id.dancingplan_chapter_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Chapter chapter = mChapters.get(position);
        holder.nameTv.setText(chapter.getName());
        holder.timeTv.setText(chapter.getTime());
        holder.orderTv.setText(mCtx.getString(R.string.pre_order_des) + chapter.getChapterorder() + mCtx.getString(R.string.after_order_des));
        return convertView;
    }

    private class ViewHolder {
        TextView nameTv;
        TextView orderTv;
        TextView timeTv;
    }

}

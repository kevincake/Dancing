package reminders.ifreedomer.com.dancing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.Util;
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
        return mContents.size();
    }

    @Override
    public Object getItem(int position) {
        return mContents.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = View.inflate(mContext, R.layout.lv_lesson_item, null);
            holder = new ViewHolder();
            holder.timeTv = (TextView) convertView.findViewById(R.id.lessontime_tv);
            holder.nameTv = (TextView) convertView.findViewById(R.id.lessonname_tv);
            holder.likeTv = (TextView) convertView.findViewById(R.id.lessonlike_tv);
            holder.authorTv = (TextView) convertView.findViewById(R.id.lessonauthor_tv);
            holder.photoIv = (ImageView) convertView.findViewById(R.id.lessonphoto_iv);
            convertView.setTag(holder);
        }

        Lesson lesson = mContents.get(position);
        lesson.setName(lesson.getName() != null ? lesson.getName() : "");
        lesson.setTime(lesson.getTime() != null ? lesson.getTime() : "");
        lesson.setAuthor(lesson.getAuthor() != null ? lesson.getAuthor() : "");
//        lesson.setLikers(lesson.getLikers()?lesson.getLikers():0);

        holder.timeTv.setText(Util.formatDuring(Long.parseLong(lesson.getTime())));
        holder.timeTv.setCompoundDrawablePadding(-2);
        holder.likeTv.setCompoundDrawablePadding(-2);
        holder.nameTv.setText(lesson.getName());
        holder.authorTv.setText(lesson.getAuthor());
        holder.likeTv.setText(lesson.getLikers()+"");


        ImageLoader loader = ImageLoader.getInstance();
        loader.displayImage(lesson.getPhoto(), holder.photoIv);
        return convertView;
    }

    private class ViewHolder {
        TextView timeTv;
        TextView likeTv;
        TextView authorTv;
        TextView nameTv;
        ImageView photoIv;
    }
}

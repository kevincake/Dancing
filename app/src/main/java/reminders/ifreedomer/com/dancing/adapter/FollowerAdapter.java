package reminders.ifreedomer.com.dancing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;

import reminders.ifreedomer.com.dancing.R;
import reminders.ifreedomer.com.dancing.bean.Follower;

/**
 * Created by eavawu on 2/2/16.
 */
public class FollowerAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Follower> mContents;
    private int mShowType;
    public FollowerAdapter(int showType,Context context, ArrayList<Follower> contents) {
        mContext = context;
        mContents = contents;
        mShowType = showType;

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
        ViewHolder holder;
        if (convertView==null){
            convertView = View.inflate(mContext, R.layout.lv_follower_item,null);
            holder = new ViewHolder();
            convertView.setTag(holder);
            holder.box = (CheckBox) convertView.findViewById(R.id.follower_checkbox);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.box.setVisibility(View.INVISIBLE);
        if (mShowType==1){
            holder.box.setVisibility(View.VISIBLE);
        }
        return convertView;
    }
    class ViewHolder{
        CheckBox box;


    }

}


package reminders.ifreedomer.com.dancing.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.ArrayList;

import me.kaede.tagview.Tag;
import me.kaede.tagview.TagView;
import reminders.ifreedomer.com.dancing.R;

/**
 * Created by eavawu on 1/29/16.
 */
public class SocialLvAdapter implements ListAdapter {
    private ArrayList mData;
    private Context mContext;

    public SocialLvAdapter(Context ctx, ArrayList data) {
        mContext = ctx;
        mData = data;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

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
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext,R.layout.lv_social_item, null);
        TagView tagView = (TagView) view.findViewById(R.id.tagview_content);
        Tag tag = new Tag("Hello", Color.parseColor("#88ffffff"));
        tag.radius = 0 ;
        tagView.addTag(tag);
        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}

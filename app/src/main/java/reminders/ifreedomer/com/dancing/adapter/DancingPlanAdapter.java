package reminders.ifreedomer.com.dancing.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import reminders.ifreedomer.com.dancing.R;

/**
 * Created by eavawu on 2/3/16.
 */
public class DancingPlanAdapter extends BaseAdapter {
    private Context mCtx;

    public DancingPlanAdapter(Context ctx) {
        mCtx = ctx;
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
        View view;

        if (position == 0) {
            view = View.inflate(mCtx, R.layout.lv_dancingplan_header_item, null);
        } else {
            view = View.inflate(mCtx, R.layout.lv_dancingplan_item, null);
        }
//        View.inflate(mCtx,R.layout.lv_dancingplan_item,null);
        return view;
    }
}

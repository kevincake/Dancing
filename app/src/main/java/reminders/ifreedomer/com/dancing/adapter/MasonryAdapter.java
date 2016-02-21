package reminders.ifreedomer.com.dancing.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import reminders.ifreedomer.com.dancing.R;

/**
 * Created by eavawu on 2/22/16.
 */
public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView>{
    private List<ReViewMsg> products;
    private final ArrayList<Integer> mHeights;


    public MasonryAdapter(List<ReViewMsg> list) {
        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            if (i<2) {
                mHeights.add( (int) (300));
            }else{
                mHeights.add( (int) (150 + Math.random() * 300));
            }
        }
        products=list;
    }

    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lv_discover_item, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(MasonryView masonryView, int position) {
        ViewGroup.LayoutParams lp = masonryView.imageView.getLayoutParams();
        lp.height = mHeights.get(position);
        masonryView.imageView.setImageResource(R.mipmap.splash);
        masonryView.textView.setText("helloworld");

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class MasonryView extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView){
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
            textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
        }

    }

}

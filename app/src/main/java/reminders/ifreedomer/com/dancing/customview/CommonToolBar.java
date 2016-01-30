package reminders.ifreedomer.com.dancing.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import reminders.ifreedomer.com.dancing.R;

/**
 * Created by eavawu on 1/30/16.
 */
public class CommonToolBar extends Toolbar {
    private TextView mCenterTv;

    public CommonToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.common_toolbar, this);
        mCenterTv = (TextView) findViewById(R.id.center_tv);
        initDefault();
    }

        public CommonToolBar(Context context) {
        super(context);
    }

    public CommonToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.common_toolbar, this);
        mCenterTv = (TextView) findViewById(R.id.center_tv);
        initDefault();

    }
    public void setCenterTitle(String text){
        mCenterTv.setText(text);

    }

    private void initDefault() {

    }


}

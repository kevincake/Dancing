package reminders.ifreedomer.com.dancing.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import reminders.ifreedomer.com.dancing.R;

public class TitleView extends FrameLayout {

    private ImageView mLeftButton;

    private TextView mTitleText;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.common_title, this);
        mTitleText = (TextView) this.findViewById(R.id.title_text);
        mLeftButton = (ImageView) this.findViewById(R.id.back_iv);
        defaultInit();
    }
    public void defaultInit(){

    }

    public void setTitleText(String text) {
        mTitleText.setText(text);
    }
//
//    public void setLeftButtonText(String text) {
//        mLeftButton.setText(text);
//    }

    public void setLeftButtonListener(View.OnClickListener l) {
        mLeftButton.setOnClickListener(l);
    }

}  
package reminders.ifreedomer.com.dancing.customview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import reminders.ifreedomer.com.dancing.R;

public class TitleView extends FrameLayout {

    private Button leftButton;

    private TextView titleText;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.common_title, this);
//        titleText = this.findViewById(R.id.title_text);
        defaultInit();
    }
    public void defaultInit(){

    }

    public void setTitleText(String text) {
        titleText.setText(text);
    }

    public void setLeftButtonText(String text) {
        leftButton.setText(text);
    }

    public void setLeftButtonListener(View.OnClickListener l) {
        leftButton.setOnClickListener(l);
    }

}  
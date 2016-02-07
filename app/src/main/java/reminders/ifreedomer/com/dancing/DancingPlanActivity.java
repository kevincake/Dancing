package reminders.ifreedomer.com.dancing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import reminders.ifreedomer.com.dancing.adapter.DancingPlanAdapter;

public class DancingPlanActivity extends Activity implements AdapterView.OnItemClickListener{
    ListView mDancingPlanLv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dancing_plan);
        mDancingPlanLv = (ListView) findViewById(R.id.dancing_plan_lv);
        mDancingPlanLv.setAdapter(new DancingPlanAdapter(this));
        mDancingPlanLv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position==0)return;
        Intent intent = new Intent(this,MediaPlayerActivity.class);
        startActivity(intent);


    }
}

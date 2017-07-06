package com.murach.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by hsMacbook on 2017. 7. 3..
 */

public class TipHistory extends Activity {

    TipDB tipDB;
    ListView historyList;

    public TipHistory()
    {
        super();

        this.tipDB = new TipDB(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_tip_history);

        this.historyList = (ListView) this.findViewById(R.id.tipListView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.historyList.setAdapter(new TipListAdapter(this.getApplicationContext(), this.tipDB));
    }
}

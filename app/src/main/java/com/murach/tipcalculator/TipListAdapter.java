package com.murach.tipcalculator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by jwanderer on 7/5/2017.
 */

public class TipListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Tip> tips;
    private TipDB tipDB;

    public TipListAdapter(Context context, TipDB tipDB)
    {
        this.context = context;
        this.tipDB = tipDB;
        this.tips = tipDB.getTips();
    }


    @Override
    public int getCount() {
        return this.tips.size();
    }

    @Override
    public Object getItem(int i) {
        return this.tips.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TipHistoryLayout layout;
        Tip tip = this.tips.get(i);

        if(view == null)
        {
            layout = new TipHistoryLayout(context, tip, tipDB);
        }
        else
        {
            layout = (TipHistoryLayout) view;
            layout.setTip(tip);
            layout.setTipDB(this.tipDB);
        }

        return layout;
    }
}

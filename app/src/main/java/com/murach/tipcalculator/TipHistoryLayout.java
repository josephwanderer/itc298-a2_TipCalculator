package com.murach.tipcalculator;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hsMacbook on 2017. 7. 3..
 */

public class TipHistoryLayout extends LinearLayout implements View.OnClickListener {

    private Context context;
    private Tip tip;
    private TipDB tipDB;

    private TextView textViewValues;
    private Button deleteButton;

    public TipHistoryLayout(Context context)
    {
        super(context);
    }

    public TipHistoryLayout(Context context, Tip tip, TipDB db) {
        this(context);

        this.context = context;
        this.tipDB = db;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.fragment_tip_history, this, true);

        this.textViewValues = (TextView) this.findViewById(R.id.detailValue);
        this.deleteButton = (Button) this.findViewById(R.id.deleteHistory);

        this.deleteButton.setOnClickListener(this);
        this.textViewValues.setText(this.tip.getBillAmountFormatted() + "\n" + this.tip.getTipPercentFormatted());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.deleteHistory:
                // delete tip history
                this.tipDB.deleteTip(tip.getId());
                this.context.startActivity(new Intent(this.getContext(), TipHistory.class).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP));
        }


    }

    public void setTip(Tip tip)
    {
        this.tip = tip;
    }

    public void setTipDB(TipDB tipDB)
    {
        this.tipDB = tipDB;
    }
}

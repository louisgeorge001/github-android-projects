package com.example.georg.spinneranddialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;

/**
 * Created by georg on 16/08/2017.
 */

public class poptime_fragment extends DialogFragment{
    TimePicker timePicker;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.poptime,container,false);
        timePicker = (TimePicker) view.findViewById(R.id.timePicker);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callmethodfortime();
            }
        });
        return view;
    }
    public void callmethodfortime()
    {
        this.dismiss();
      //  String time = timePicker.getHour()+":"+timePicker.getMinute();
        MainActivity ma = (MainActivity)getActivity();
      //  ma.settime(time);
    }


}

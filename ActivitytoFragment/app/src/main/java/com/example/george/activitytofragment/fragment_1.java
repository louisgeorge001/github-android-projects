package com.example.george.activitytofragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by george on 9/13/17.
 */

public class fragment_1 extends Fragment implements View.OnClickListener {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment1, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    private void initview(View view)
    {
        Button button_1 = (Button) view.findViewById(R.id.button_1);
        button_1.setOnClickListener(this);

    }
    public void changefragment()
    {
        getFragmentManager().beginTransaction().replace(R.id.ggg,new fragment_2()).addToBackStack(null).commit();
    }
    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.button_1:
                changefragment();
                break;
        }
    }

}

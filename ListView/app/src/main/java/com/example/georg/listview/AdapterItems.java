package com.example.georg.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by georg on 14/08/2017.
 */

public class AdapterItems {
    public int ID;
    public String JobTitle;
    public String Description;
    Context context;
    AdapterItems(int ID, String JobTitle,String Description)
    {
        this.ID = ID;
        this.JobTitle = JobTitle;
        this.Description = Description;
    }





}

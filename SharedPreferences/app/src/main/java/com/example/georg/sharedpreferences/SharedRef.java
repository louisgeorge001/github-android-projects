package com.example.georg.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by georg on 17/08/2017.
 */

public class SharedRef {
    SharedPreferences sharedPreferences;
    public SharedRef(Context context){
        sharedPreferences = context.getSharedPreferences("myReference",Context.MODE_PRIVATE);
    }
    public void saveData(String uname,String pword)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("uname",uname);
        editor.putString("pword",pword);
        editor.commit();
    }
    public String loadData(){
        String FileContent = "uname:"+sharedPreferences.getString("uname","No Name");
        FileContent+="pword:"+sharedPreferences.getString("pword","No Name");
        return FileContent;
    }
}

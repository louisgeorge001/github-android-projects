package com.example.georg.menu;

import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainmenu,menu);
        SearchView sv = (SearchView) menu.findItem(R.id.searchbarr).getActionView();
        SearchManager sm = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        sv.setSearchableInfo(sm.getSearchableInfo(getComponentName()));
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(),query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(getApplicationContext(),newText,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        return true;
    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        switch(item.getItemId())
//        {
//            case R.id.Add:
//                Toast.makeText(getApplicationContext(),"You clicked on Add!",Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.Settings:
//                Toast.makeText(getApplicationContext(),"You clicked on Settings!",Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.Home:
//                Toast.makeText(getApplicationContext(),"You clicked on Home!",Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}

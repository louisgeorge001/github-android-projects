package com.example.george.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.widget.Toast;

/**
 * Created by george on 8/27/17.
 */

public class dbmanager {
    private SQLiteDatabase sqLiteDatabasee;
    static final String dbname = "students";
    static final String tbname = "logins";
    static final String user_name = "user_name";
    static final String user_password = "user_password";
    static final int db_version = 1;
    //create table
    static final String createtable = "CREATE TABLE IF NOT EXISTS "+tbname+
            "(ID integer PRIMARY KEY AUTOINCREMENT,"+user_name+" TEXT,"+user_password+" TEXT)";
    static class databasehelper extends SQLiteOpenHelper
    {
        Context context;
        databasehelper(Context context)
        {
            super(context,dbname,null,db_version);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(createtable);
            Toast.makeText(context,"Table is created!",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+tbname);
            onCreate(sqLiteDatabase);
        }
    }
    public dbmanager(Context context)
    {
        databasehelper databaseHelper = new databasehelper(context);
        sqLiteDatabasee=databaseHelper.getWritableDatabase();
    }
    //insert values
    public long insertdata(ContentValues contentValues)
    {
        long ID = sqLiteDatabasee.insert(tbname,"",contentValues);
        return ID;
    }
    //retrieve values
    public Cursor query(String[] projection,String Selection,String[] SelectionArgs,String SortOrder)
    {
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(tbname);
        Cursor cursor = qb.query(sqLiteDatabasee,projection,Selection,SelectionArgs,null,null,SortOrder);
        return cursor;
    }

}

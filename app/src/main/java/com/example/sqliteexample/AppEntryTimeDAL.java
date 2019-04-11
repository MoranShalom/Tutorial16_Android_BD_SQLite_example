package com.example.sqliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AppEntryTimeDAL {

    private AppEntryTimeDBHelper helper ;

    public AppEntryTimeDAL (Context context){

        helper = new AppEntryTimeDBHelper(context);
    }




        // insert data to db
    public void addEntryTime (String time ){

        //get DB
        SQLiteDatabase db= helper.getWritableDatabase();

        // value to save (set data)
        ContentValues values= new ContentValues();
        values.put(AppEntryTimeContract.AppEntryTime.ENTRY_TIME, time); // entey value to columns ENTRY_TIME

        // save the value
        db.insert(AppEntryTimeContract.AppEntryTime.TABLE_NAME, null ,values);
        db.close();

    }

    //select
    public Cursor getAllEntryTimesCursor(){

        //Get db
        SQLiteDatabase db= helper.getWritableDatabase();

        // get data
        Cursor c= db.rawQuery("SELECT * FROM" + AppEntryTimeContract.AppEntryTime.TABLE_NAME, null);
        return c;
    }


    public ArrayList getAllEntryTimesList(){

        ArrayList entryTimeList = new ArrayList();

        //get cursor
        Cursor c = getAllEntryTimesCursor();

        if (c != null){

            while (c.moveToNext()){

                //get column index
                int entryTimeColumnIndex = c.getColumnIndex(AppEntryTimeContract.AppEntryTime.ENTRY_TIME);

                // get column data - entry_time
                String entryTimes= c.getString(entryTimeColumnIndex);

                //save in the array
                entryTimeList.add(entryTimes);
            }
        }

        // return the array list of all the entryTimes in the table
        return entryTimeList;

    }
}

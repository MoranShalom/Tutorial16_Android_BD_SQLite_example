package com.example.sqliteexample;

import android.provider.BaseColumns;

class AppEntryTimeContract {

    public AppEntryTimeContract(){};

    public static abstract class AppEntryTime implements BaseColumns{

        public static final String TABLE_NAME= " entryTimes";
        public static final String ENTRY_TIME = "entryTimeColumn";

    }
}

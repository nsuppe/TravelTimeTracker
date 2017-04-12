package com.example.tannerdouglas.traveltimetracker.data;

import android.provider.BaseColumns;

public final class TimersContract {

    public static final class UsersEntry implements BaseColumns{
        //Table name
        public static final String TABLE_NAME = "user";
        //column (field) name
        public static final String U_ID = BaseColumns._ID;
        public static final String COLUMN_FNAME = "fname";
        public static final String COLUMN_LNAME = "lname";
        public static final String COLUMN_EMAIL = "email";
    }

    public static final class TimerListEntry implements BaseColumns{
        //Table name
        public static final String TABLE_NAME = "timerList";
        //column (field) name
        public static final String L_ID = BaseColumns._ID;
        public static final String COLUMN_U_ID = "userId";
        public static final String COLUMN_TIMERCOUNT = "count";
        public static final String COLUMN_ISEMPTY = "isEmpty";
    }

    public static final class TimerEntry implements BaseColumns{
        //Table name
        public static final String TABLE_NAME = "timer";
        //column (field) name
        public static final String T_ID = BaseColumns._ID;
        public static final String COLUMN_L_ID = "listId";
        public static final String COLUMN_NAME = "timerName";
        public static final String COLUMN_START = "start";
        public static final String COLUMN_END = "end";
        public static final String COLUMN_TOTAL = "totalTime";
        public static final String COLUMN_ISDONE = "isDone";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }

    public static final class ComponentEntry implements BaseColumns{
        //Table name
        public static final String TABLE_NAME = "component";
        //column (field) name
        public static final String C_ID = BaseColumns._ID;
        public static final String COLUMN_DURATION = "duration";
    }

    //TODO: Test composite primary key implementation
    public static final class BridgeEntry implements BaseColumns{
        //Table name
        public static final String TABLE_NAME = "bridge";
        //column (field) name
        public static final String B_ID = BaseColumns._ID;
        public static final String COLUMN_T_ID = "timerID";
        public static final String COLUMN_C_ID = "componentID";
        public static final String COLUMN_DATERECORDED = "date";
        public static final String COLUMN_ISEMPTY = "isEmpty";
    }


}

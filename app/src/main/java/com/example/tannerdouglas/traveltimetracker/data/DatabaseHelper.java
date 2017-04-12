package com.example.tannerdouglas.traveltimetracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tannerdouglas.traveltimetracker.data.TimersContract.UsersEntry;
import com.example.tannerdouglas.traveltimetracker.data.TimersContract.TimerListEntry;
import com.example.tannerdouglas.traveltimetracker.data.TimersContract.TimerEntry;
import com.example.tannerdouglas.traveltimetracker.data.TimersContract.ComponentEntry;
import com.example.tannerdouglas.traveltimetracker.data.TimersContract.BridgeEntry;

public class DatabaseHelper extends SQLiteOpenHelper {
    //Constants for db name and version
    private static final String DATABASE_NAME = "travelTimeTrackerApp.db";
    private static final int DATABASE_VERSION = 1;

    //SQL to create tables
    private static final String TABLE_USERS_CREATE =
            "CREATE TABLE " + UsersEntry.TABLE_NAME + " (" +
                    UsersEntry.U_ID + " INTEGER PRIMARY KEY, " +
                    UsersEntry.COLUMN_FNAME + " TEXT " +
                    UsersEntry.COLUMN_LNAME + " TEXT " +
                    UsersEntry.COLUMN_EMAIL + " TEXT " +
                    ")";

    private static final String TABLE_TIMERLIST_CREATE =
            "CREATE TABLE " + TimerListEntry.TABLE_NAME + " (" +
                    TimerListEntry.L_ID + " INTEGER PRIMARY KEY, " +
                    TimerListEntry.COLUMN_U_ID + " INTEGER NOT NULL, " +
                    TimerListEntry.COLUMN_TIMERCOUNT + " INTEGER, " +
                    TimerListEntry.COLUMN_ISEMPTY + " INTEGER, " +
                    " FOREIGN KEY(" + TimerListEntry.COLUMN_U_ID + ") REFERENCES " + UsersEntry.TABLE_NAME
                    + "(" + UsersEntry.U_ID + ") " +
                    ")";

    private static final String TABLE_TIMERS_CREATE =
            "CREATE TABLE " + TimerEntry.TABLE_NAME + " (" +
                    TimerEntry.T_ID + " INTEGER PRIMARY KEY, " +
                    TimerEntry.COLUMN_L_ID + " INTEGER NOT NULL, " +
                    TimerEntry.COLUMN_NAME + " TEXT, " +
                    TimerEntry.COLUMN_START + " TEXT, " +
                    TimerEntry.COLUMN_END + " TEXT, " +
                    TimerEntry.COLUMN_TOTAL + " TEXT, " +
                    TimerEntry.COLUMN_ISDONE + " INTEGER, " +
                    TimerEntry.COLUMN_TIMESTAMP + " TEXT default CURRENT_TIMESTAMP, " +
                    " FOREIGN KEY(" + TimerEntry.COLUMN_L_ID + ") REFERENCES " + TimerListEntry.TABLE_NAME
                    + "(" + TimerListEntry.L_ID + ") " +
                    ")";

    private static final String TABLE_COMPONENT_CREATE =
            "CREATE TABLE " + ComponentEntry.TABLE_NAME + " (" +
                    ComponentEntry.C_ID + " INTEGER PRIMARY KEY, " +
                    ComponentEntry.COLUMN_DURATION + " INTEGER " +
                    ")";

    private static final String TABLE_BRIDGE_CREATE =
            "CREATE TABLE " + BridgeEntry.TABLE_NAME + " (" +
                    BridgeEntry.B_ID + " INTEGER PRIMARY KEY, " +
                    BridgeEntry.COLUMN_T_ID + " INTEGER NOT NULL, " +
                    BridgeEntry.COLUMN_C_ID + " INTEGER NOT NULL, " +
                    BridgeEntry.COLUMN_DATERECORDED + " TEXT, " +
                    BridgeEntry.COLUMN_ISEMPTY + " INTEGER, " +
                    " FOREIGN KEY(" + BridgeEntry.COLUMN_T_ID + ") REFERENCES " + TimerEntry.TABLE_NAME
                    + "(" + TimerEntry.T_ID + ") " +
                    " FOREIGN KEY(" + BridgeEntry.COLUMN_C_ID + ") REFERENCES " + ComponentEntry.TABLE_NAME
                    + "(" + ComponentEntry.C_ID + ") " +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { //order based on Foreign Key usage
        db.execSQL(TABLE_USERS_CREATE);
        db.execSQL(TABLE_TIMERLIST_CREATE);
        db.execSQL(TABLE_TIMERS_CREATE);
        db.execSQL(TABLE_COMPONENT_CREATE);
        db.execSQL(TABLE_BRIDGE_CREATE);
        //seed(db);
    }

    //TODO: rework onUpgrade()
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + UsersEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TimerListEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TimerEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ComponentEntry.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + BridgeEntry.TABLE_NAME);
        onCreate(db);
    }
}
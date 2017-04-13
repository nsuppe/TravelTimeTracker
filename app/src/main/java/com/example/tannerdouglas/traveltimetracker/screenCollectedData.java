package com.example.tannerdouglas.traveltimetracker;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import com.example.tannerdouglas.traveltimetracker.data.DatabaseHelper;
import com.example.tannerdouglas.traveltimetracker.data.TimersContract;

import java.util.ArrayList;
import java.util.List;

public class screenCollectedData extends AppCompatActivity {
    static String TAG = "Collected Data";


    public void btnClick(){
        Button btnExport = (Button)(findViewById(R.id.btnExport));
        btnExport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Exporting Data!");
                //Intent intent = new Intent(screenCollectedData.this, screenLanding.class);
                finish();
                //startActivity(intent);
            }
        });
        Button btnCancel = (Button) (findViewById(R.id.btnCancel));
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Canceling Data Export!");
                //Intent intent = new Intent(screenCreateTimer.this, screenTimerList.class);
                finish();
                //startActivity(intent);
            }
        });
    }

    public void loadData(){

        //create DatabaseHelper object passing the current context
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                TimersContract.TimerEntry.T_ID,
                TimersContract.TimerEntry.COLUMN_TOTAL,
                TimersContract.TimerEntry.COLUMN_TIMESTAMP
        };

        String sortOrder = TimersContract.TimerEntry.COLUMN_TIMESTAMP + " DESC ";

        Cursor cursor = db.query(
                TimersContract.TimerEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        /*List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(TimersContract.TimerEntry.T_ID));
            itemIds.add(itemId);
        }
        cursor.close();*/

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_collected_data);
        Log.i(TAG, "View Collected Data!");


        loadData();

        btnClick();
    }
}

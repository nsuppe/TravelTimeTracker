package com.example.tannerdouglas.traveltimetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_collected_data);
        Log.i(TAG, "View Collected Data!");
        btnClick();
    }
}

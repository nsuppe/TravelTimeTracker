package com.example.tannerdouglas.traveltimetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.example.tannerdouglas.traveltimetracker.Timer;

public class screenCreateTimer extends AppCompatActivity {
    static String TAG = "Create Timer";

    Timer testTimer = new Timer();

    public void btnClick(){
        Button btnSave = (Button)(findViewById(R.id.btnSave));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Saving New Button Creation!");
                //Intent intent = new Intent(screenCreateTimer.this, screenTimerList.class);
                finish();
                //startActivity(intent);
            }
        });
        Button btnCancel = (Button) (findViewById(R.id.btnCancel));
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Canceling New Button Creation!");
                //Intent intent = new Intent(screenCreateTimer.this, screenTimerList.class);
                finish();
                //startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_create_timer);
        Log.i(TAG, "Create Timer!");
        btnClick();
    }
}

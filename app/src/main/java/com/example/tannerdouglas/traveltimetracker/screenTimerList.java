package com.example.tannerdouglas.traveltimetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class screenTimerList extends AppCompatActivity {
    static String TAG = "Timer List";

    public void btnClick(){
        Button btnCreateTimer = (Button)(findViewById(R.id.btnCreateTimer));
        btnCreateTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Creating Timer!");
                Intent intent = new Intent(screenTimerList.this, screenCreateTimer.class);
                //finish();
                startActivity(intent);
            }
        });
        Button btnDone = (Button)(findViewById(R.id.btnDone));
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Done Adding Screen!");
                //Intent intent = new Intent(screenTimerList.this, screenLanding.class);
                finish();
                //startActivity(intent);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_timer_list);
        Log.i(TAG, "Select Timer!");
        btnClick();
    }
}


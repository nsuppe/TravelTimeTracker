package com.example.tannerdouglas.traveltimetracker;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.TextView;
import android.database.sqlite.SQLiteDatabase;
import com.example.tannerdouglas.traveltimetracker.data.DatabaseHelper;
import com.example.tannerdouglas.traveltimetracker.data.TimersContract;

/*class TestTimer extends screenLanding{
    String name = "Test";
    TextView timerTextView;
    long startTime = 0;

    //runs without a timer by reposting this handler at the end of the runnable
    Handler timerHandler = new Handler();

    Runnable timerRunnable = new Runnable() {

        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler.postDelayed(this, 500);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        timerHandler.removeCallbacks(timerRunnable);
        Button b = (Button)findViewById(R.id.btnStart);
        b.setText("start");
    }

    public void btnClick(){
        Button btnStart = (Button) findViewById(R.id.btnStart);
        //btnStart.setText("start");
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().equals("stop")) {
                    timerHandler.removeCallbacks(timerRunnable);
                    b.setText("start");
                } else {
                    startTime = System.currentTimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    b.setText("stop");
                }
            }
        });
    }

}*/

public class screenLanding extends AppCompatActivity {
    static String TAG = "Landing";
    private Button timer1, timer2, timer3, timer4, timer5, btnStartAll, btnStopAll;
    private TextView timerTextView1, timerTextView2, timerTextView3, timerTextView4, timerTextView5;
    long startTime1 = 0, startTime2 = 0, startTime3 = 0, startTime4 = 0, startTime5 = 0;
    //Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_landing);

        //create DatabaseHelper object passing the current context
        DatabaseHelper helper = new DatabaseHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Log.i(TAG, "Login Successful!");

        btnClick();
        //tried to implement intents into startup
        /*timerTextView = (TextView) findViewById(R.id.timerTextView);

        Intent timerIntent = new Intent(screenLanding.this, Timer.class);
        timer = new Timer();*/
    }



    //---------------------------------------------------------------------------------------
    //runs without a timer by re-posting the handler at the end of the runnable (Android Best Practice)
    // Handler for Timer 1
    Handler timerHandler1 = new Handler();

    Runnable timerRunnable1 = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime1;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            //debug
            Log.d("RunTest","run was called");

            timerTextView1.setText(String.format("%d:%02d", minutes, seconds)); //formats the time

            timerHandler1.postDelayed(this, 500); //updates the screen after 500ms delay
        }
    };

    // Handler for Timer 2
    Handler timerHandler2 = new Handler();

    Runnable timerRunnable2 = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime2;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView2.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler2.postDelayed(this, 500);
        }
    };

    // Handler for Timer 3
    Handler timerHandler3 = new Handler();

    Runnable timerRunnable3 = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime3;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView3.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler3.postDelayed(this, 500);
        }
    };

    // Handler for Timer 4
    Handler timerHandler4 = new Handler();

    Runnable timerRunnable4 = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime4;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView4.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler4.postDelayed(this, 500);
        }
    };

    // Handler for Timer 5
    Handler timerHandler5 = new Handler();

    Runnable timerRunnable5 = new Runnable() {
        @Override
        public void run() {
            long millis = System.currentTimeMillis() - startTime5;
            int seconds = (int) (millis / 1000);
            int minutes = seconds / 60;
            seconds = seconds % 60;

            timerTextView5.setText(String.format("%d:%02d", minutes, seconds));

            timerHandler5.postDelayed(this, 500);
        }
    };

    //--------------------------------------------------------------------------------------
    /*@Override
    public void onPause() {
        super.onPause();
        timerHandler2.removeCallbacks(timerRunnable2);
        Button b = (Button)findViewById(R.id.timer1);
        b.setText("start");
    }*/
    //---------------------------------------------------------------------------------------


    public void btnClick(){

        //Navigates to Add timer screen (timerList)
        Button btnAddTimer = (Button)(findViewById(R.id.btnAddTimer));
        btnAddTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Adding Timer!");
                Intent CreateTimer = new Intent(screenLanding.this, screenTimerList.class);
                startActivity(CreateTimer);
            }
        });

        //Saves the data of the timers
        Button btnSave = (Button)(findViewById(R.id.btnSave));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Saving!");

                //Todo: pass the timer data of selected timers to the SQLite db
                DatabaseHelper helper = new DatabaseHelper(getBaseContext());
                SQLiteDatabase db = helper.getWritableDatabase();

                ContentValues values = new ContentValues();

                if(findViewById(R.id.checkBox1).isActivated() && timer1.getText().equals("start") && timerTextView1.getText() != null){
                    values.put(TimersContract.TimerEntry.COLUMN_TOTAL, (String) (timerTextView1.getText()));
                    db.insert(TimersContract.TimerEntry.TABLE_NAME, null, values);
                }


                // ---------------------------------------------------------------------
                // Navigate to Collected Data Screen
                Intent Save = new Intent(screenLanding.this, screenCollectedData.class);
                startActivity(Save);
            }
        });

        //Timer 1
        timer1 = (Button)(findViewById(R.id.timer1));
        timerTextView1 = (TextView) findViewById(R.id.timerTextView1);

        timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer1.getText().equals("stop")) {
                    //timer.stop();
                    timerHandler1.removeCallbacks(timerRunnable1); //stop
                    timer1.setText("start");
                } else {
                    startTime1 = System.currentTimeMillis();
                    timerHandler1.postDelayed(timerRunnable1, 500);
                    timer1.setText("stop");
                }
            }
        });

        //Timer 2
        timer2 = (Button)(findViewById(R.id.timer2));
        timerTextView2 = (TextView) findViewById(R.id.timerTextView2);

        timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer2.getText().equals("stop")) {
                    //timer.stop();
                    timerHandler2.removeCallbacks(timerRunnable2); //stop
                    timer2.setText("start");
                } else {
                    //timer.start();
                    startTime2 = System.currentTimeMillis();
                    timerHandler2.postDelayed(timerRunnable2, 500);
                    timer2.setText("stop");
                }
            }
        });

        //Timer 3
        timer3 = (Button)(findViewById(R.id.timer3));
        timerTextView3 = (TextView) findViewById(R.id.timerTextView3);

        timer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer3.getText().equals("stop")) {
                    //timer.stop();
                    timerHandler3.removeCallbacks(timerRunnable3); //stop
                    timer3.setText("start");
                } else {
                    //timer.start();
                    startTime3 = System.currentTimeMillis();
                    timerHandler3.postDelayed(timerRunnable3, 500);
                    timer3.setText("stop");
                }
            }
        });

        //Timer 4
        timer4 = (Button)(findViewById(R.id.timer4));
        timerTextView4 = (TextView) findViewById(R.id.timerTextView4);

        timer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer4.getText().equals("stop")) {
                    //timer.stop();
                    timerHandler4.removeCallbacks(timerRunnable4); //stop
                    timer4.setText("start");
                } else {
                    //timer.start();
                    startTime4 = System.currentTimeMillis();
                    timerHandler4.postDelayed(timerRunnable4, 500);
                    timer4.setText("stop");
                }
            }
        });

        //Timer 5
        timer5 = (Button)(findViewById(R.id.timer5));
        timerTextView5 = (TextView) findViewById(R.id.timerTextView5);

        timer5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer5.getText().equals("stop")) {
                    //timer.stop();
                    timerHandler5.removeCallbacks(timerRunnable5); //stop
                    timer5.setText("start");
                } else {
                    //timer.start();
                    startTime5 = System.currentTimeMillis();
                    timerHandler5.postDelayed(timerRunnable5, 500);
                    timer5.setText("stop");
                }
            }
        });

        //Start All
        btnStartAll = (Button)(findViewById(R.id.btnStartAll));

        btnStartAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer1.getText().equals("start")){
                    startTime1 = System.currentTimeMillis();
                    timerHandler1.postDelayed(timerRunnable1, 500);
                    timer1.setText("stop");
                }
                if (timer2.getText().equals("start")){
                    startTime2 = System.currentTimeMillis();
                    timerHandler2.postDelayed(timerRunnable2, 500);
                    timer2.setText("stop");
                }
                if (timer3.getText().equals("start")){
                    startTime3 = System.currentTimeMillis();
                    timerHandler3.postDelayed(timerRunnable3, 500);
                    timer3.setText("stop");
                }

                if (timer4.getText().equals("start")){
                    startTime4 = System.currentTimeMillis();
                    timerHandler4.postDelayed(timerRunnable4, 500);
                    timer4.setText("stop");
                }

                if (timer5.getText().equals("start")){
                    startTime5 = System.currentTimeMillis();
                    timerHandler5.postDelayed(timerRunnable5, 500);
                    timer5.setText("stop");
                }
            }
        });


        //Stop All
        btnStopAll = (Button)(findViewById(R.id.btnStopAll));

        btnStopAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timer1.getText().equals("stop")){
                    timerHandler1.removeCallbacks(timerRunnable1);
                    timer1.setText("start");
                }
                if (timer2.getText().equals("stop")){
                    timerHandler2.removeCallbacks(timerRunnable2);
                    timer2.setText("start");
                }
                if (timer3.getText().equals("stop")){
                    timerHandler3.removeCallbacks(timerRunnable3);
                    timer3.setText("start");
                }

                if (timer4.getText().equals("stop")){
                    timerHandler4.removeCallbacks(timerRunnable4);
                    timer4.setText("start");
                }

                if (timer5.getText().equals("stop")){
                    timerHandler5.removeCallbacks(timerRunnable5);
                    timer5.setText("start");
                }
            }
        });

    }
}

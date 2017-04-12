package com.example.tannerdouglas.traveltimetracker;

import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Nicholas Suppe on 3/24/2017.
 */

public class Timer extends screenLanding{
    private String timerName = "Generic";
    private int timerID = 1;
    private int startTime = 0;
    private int totalTime = 0;
    private String dateRecorded = "";

    public Timer(){

    }

    public String getTimerName() {
        return timerName;
    }

    public void setTimerName(String timerName) {
        this.timerName = timerName;
    }

    public int getTimerID() {
        return timerID;
    }

    public void setTimerID(int timerID) {
        this.timerID = timerID;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public String getDateRecorded(){
        return dateRecorded;
    }

    public void setDateRecorded(){
        this.dateRecorded = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
    }

    void addTimer(){    //used to add to database (May Need To be moved.)


    }

    void deleteTimer(){

    }

    void start(){
        startTime = (int) System.currentTimeMillis();
        //timerHandler.postDelayed(timerRunnable, 500);
    }

    void stop(){
        //timerHandler.removeCallbacks(timerRunnable);
        setDateRecorded();
    }

    public void run() {
        Button btnStart = (Button) (findViewById(R.id.timer1));
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                if (b.getText().equals("stop")) {
                    stop();
                } else {
                    start();
                }
            }
        });
    }
}

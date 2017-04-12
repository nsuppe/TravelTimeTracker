package com.example.tannerdouglas.traveltimetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class screenLogin extends AppCompatActivity {
    static String TAG = "Login";

    public void btnClick(){
        Button btnLogin = (Button)(findViewById(R.id.btnLogin));
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Button was clicked!");
                Intent intent = new Intent(screenLogin.this, screenLanding.class);
                startActivity(intent);
            }
        });
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_login);
        Log.i(TAG, "Application has started!");
        btnClick();
    }
}

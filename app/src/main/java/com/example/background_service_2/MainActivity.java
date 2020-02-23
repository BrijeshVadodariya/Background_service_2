package com.example.background_service_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button start,stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.laval);
        start = findViewById(R.id.buttonStart);
        stop = findViewById(R.id.buttonStop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //   Enter();
                startService(new Intent(MainActivity.this, MyService.class));
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this, MyService.class));
                //  exit();
            }
        });
    }
}

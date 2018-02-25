package ru.park.examplesmail.screentime;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView start_text = findViewById(R.id.start_text);
        start_text.setTextSize(30);
        start_text.setTextColor(Color.BLACK);
    }
}

package ru.park.examplesmail.screentime;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class TimeActivity extends AppCompatActivity {

    public static final String TIME = "you time";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_activity);

        long my_time = getIntent().getLongExtra(TIME, 0);

        TextView my_result = findViewById(R.id.time_text);
        if (my_time < 15) {
            my_result.setTextColor(Color.RED);
        }
        else {
            my_result.setTextColor(Color.GREEN);
        }
        my_result.setTextSize(30);
        my_result.setText("You time: " + Long.toString(my_time)+" sec");

    }
}

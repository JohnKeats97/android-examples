package ru.park.examples_mail.numbers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Array;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Вставляем numbers в activity_main
        final ViewGroup container = findViewById(R.id.container);
        final LayoutInflater inflater = LayoutInflater.from(this);
        final View numbersView = inflater.inflate(R.layout.numbers, container, false);
        container.addView(numbersView);

        final int[] btnArray = {R.id.btn_1, R.id.btn_2, R.id.btn_3,
                R.id.btn_4, R.id.btn_5, R.id.btn_6, R.id.btn_7,
                R.id.btn_8, R.id.btn_9, R.id.btn_0};

        final TextView text = findViewById(R.id.text);

        for (int i = 0; i<btnArray.length; i++) {
            final Button btn = findViewById(btnArray[i]);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
                    String text1 = text.getText().toString();
                    String text2 = btn.getText().toString();
                    text.setText(text1 + text2);
                }
            });
        }

        final Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String myText = text.getText().toString();
                text.setText(myText.substring(0, myText.length()-1));
            }
        });
        btnBack.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                text.setText("");
                return true;
            }
        });


    }
}

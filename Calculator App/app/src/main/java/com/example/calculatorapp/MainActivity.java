package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    Button addition, subtraction, multiply, division;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        addition = findViewById(R.id.addition);
        subtraction = findViewById(R.id.subtraction);
        multiply = findViewById(R.id.multiply);
        division = findViewById(R.id.division);
        tv1 = findViewById(R.id.tv1);

            addition.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int f,s, a;
                    f = Integer.parseInt(et1.getText().toString());
                    s = Integer.parseInt(et2.getText().toString());
                    a = f+s;
                    tv1.setText("Result = " +a);
                }
            });

            subtraction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int f,s, a;
                    f = Integer.parseInt(et1.getText().toString());
                    s = Integer.parseInt(et2.getText().toString());
                    a = f-s;
                    tv1.setText("Result = " +a);
                }
            });

            multiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int f,s, a;
                    f = Integer.parseInt(et1.getText().toString());
                    s = Integer.parseInt(et2.getText().toString());
                    a = f*s;
                    tv1.setText("Result = " +a);
                }
            });

            division.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    float f,s;
                    float a;
                    f = Integer.parseInt(et1.getText().toString());
                    s = Integer.parseInt(et2.getText().toString());
                    a = f/s;
                    tv1.setText("Result = " +a);
                }
            });



    }
}

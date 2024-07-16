package com.application.pict_app.App.View.button3_view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.application.pict_app.App.MainActivity;
import com.application.pict_app.App.View.Movie_Room.MovieListView;
import com.application.pict_app.App.View.RetrofitList.RetrofitView;
import com.application.pict_app.R;

public class Button3 extends AppCompatActivity implements View.OnClickListener {

    Button button,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        initiliazation();
        generateEvents();
    }

    private void generateEvents() {
        button.setOnClickListener(Button3.this);
        button2.setOnClickListener(Button3.this);
    }

    private void initiliazation() {
        button = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                Intent intent1 = new Intent(Button3.this, RetrofitView.class);
                startActivity(intent1);
                break;
            case R.id.button2:
                Intent intent2 = new Intent(Button3.this, MovieListView.class);
                startActivity(intent2);
                break;
        }
    }
}
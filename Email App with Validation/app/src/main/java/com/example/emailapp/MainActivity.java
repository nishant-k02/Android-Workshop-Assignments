package com.example.emailapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText etTo, etMessage, etSubject;
    Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTo = findViewById(R.id.et_to);
        etMessage = findViewById(R.id.et_message);
        etSubject = findViewById(R.id.et_subject);
        btSend = findViewById(R.id.bt_send);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateEmailAddress(etTo);
                Intent intent = new Intent(Intent.ACTION_VIEW
                , Uri.parse("mailto:" + etTo.getText().toString()));
                intent.putExtra(Intent.EXTRA_SUBJECT,etSubject.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT,etMessage.getText().toString());
                startActivity(intent);
            }
        });
    }
    private boolean validateEmailAddress(EditText etTo)
    {
        String emailInput = etTo.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches())
        {
            Toast.makeText(this, "Email Validated Successfully", Toast.LENGTH_SHORT).show();
            return true;

        }
        else
        {
            Toast.makeText(this, "Invlid Email Address", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
}
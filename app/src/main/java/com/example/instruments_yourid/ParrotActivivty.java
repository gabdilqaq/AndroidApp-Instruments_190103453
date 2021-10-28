package com.example.instruments_yourid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class ParrotActivivty extends AppCompatActivity {

    TextView receive_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parrot_activivty);
        Intent intent = getIntent();
        String message = intent.getStringExtra("msg");

        receive_message = (TextView)findViewById(R.id.message);
        receive_message.setText(message);

    }
}
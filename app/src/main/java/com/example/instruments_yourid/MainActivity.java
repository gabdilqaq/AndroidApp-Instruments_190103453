package com.example.instruments_yourid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView main_text;
    Spinner languages;
    Button change_btn;

    Button send_btn;
    EditText message;

    Button start_btn;

    Button solve_btn;

    Button show_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadLocale();

        main_text = (TextView)findViewById(R.id.main_text);
        languages = (Spinner)findViewById(R.id.languages);
        change_btn = (Button)findViewById(R.id.change_btn);

        send_btn = (Button) findViewById(R.id.send);
        message =  (EditText) findViewById(R.id.editTextMessage);

        start_btn = (Button)findViewById(R.id.start);

        solve_btn = (Button)findViewById(R.id.solve);

        show_btn = (Button)findViewById(R.id.show);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.lang_arr));

        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        languages.setAdapter(spinnerArrayAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lang = String.valueOf(languages.getSelectedItem());
                if(lang.equals("US")){
                    setLocale("en");
                    recreate();
                }
                else if(lang.equals("RU")){
                    setLocale("ru");
                    recreate();
                }
                else{
                    setLocale("kk");
                    recreate();
                }
            }
        });

        send_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openParrotActivity();
            }
        });

        start_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openStopwatchActivity();
            }
        });
        solve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConverterActivity();
            }
        });
        show_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactsActivity();
            }
        });

    }

    private void openContactsActivity() {
        Intent intent = new Intent(this, ContactsCategoryActivity.class );
        startActivity(intent);
    }

    private void openStopwatchActivity() {
        Intent intent = new Intent(this, StopwatchActivity.class );
        startActivity(intent);
    }

    public void openParrotActivity(){
        Intent intent = new Intent(this, ParrotActivivty.class );
        String msg = message.getText().toString();
        intent.putExtra("msg", msg);

        startActivity(intent);
    }
    public void openConverterActivity(){
        Intent intent = new Intent(this, ConverterActivity.class );

        startActivity(intent);
    }

    private void setLocale(String lang){
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.apply();
    }
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }
}
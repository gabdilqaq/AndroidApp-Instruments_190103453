package com.example.instruments_yourid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ConverterActivity extends AppCompatActivity {
    EditText given_number;
    RadioGroup rg;
    RadioButton radioButton;

    Button convert_btn;

    TextView tenge;
    TextView lira;
    TextView dollor;
    TextView euro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);



        RadioGroup rg = (RadioGroup) findViewById(R.id.rg_dtype);
        convert_btn = (Button)findViewById(R.id.convert_btn);

        tenge = (TextView)findViewById(R.id.tenge_m);
        lira = (TextView)findViewById(R.id.lira_m);
        dollor = (TextView)findViewById(R.id.dollor_m);
        euro = (TextView)findViewById(R.id.euro_m);

        given_number = (EditText)findViewById(R.id.given_number);


        convert_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (given_number.getText().toString().equals("") || (rg.getCheckedRadioButtonId()==-1) ){
                    Toast.makeText(ConverterActivity.this , "Please enter the amount or select the currency" , Toast.LENGTH_SHORT).show();
                }
                else{
                    int selectedId = rg.getCheckedRadioButtonId();
                    radioButton = (RadioButton) findViewById(selectedId);

                    String currency = radioButton.getText().toString();
                    int amount = Integer.valueOf(given_number.getText().toString());


                    switch (currency) {
                        case "DOLLOR":
                            tenge.setText(String.valueOf(amount * 430));
                            lira.setText(String.valueOf(amount * 9));
                            euro.setText(String.format("%.2f", (((double) amount) / (1.16))));
                            dollor.setText(String.valueOf(amount));
                            break;
                        case "TENGE":
                            tenge.setText(String.valueOf(amount));
                            lira.setText(String.format("%.2f", ((double) amount) / 47));
                            euro.setText(String.format("%.2f", ((double) amount) / 491));
                            dollor.setText(String.format("%.2f", ((double) amount) / 430));
                            break;
                        case "LIRA":
                            lira.setText(String.valueOf(amount));
                            tenge.setText(String.format("%.2f",amount * 47));
                            euro.setText(String.format("%.2f", ((double) amount) / 10.37));
                            dollor.setText(String.format("%.2f", ((double) amount) / 8.96));
                            break;
                        case "EURO":
                            euro.setText(String.valueOf(amount));
                            tenge.setText(String.format("%.2f",amount * 491.34));
                            lira.setText(String.format("%.2f",amount * 10.37));
                            dollor.setText(String.format("%.2f",amount * 1.16));
                            break;
                    }
                }
            }
        });
    }
}
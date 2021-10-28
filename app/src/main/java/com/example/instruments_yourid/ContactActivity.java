package com.example.instruments_yourid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {
    public static final String EXTRA_CONTACTNO = "contactNo";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //Get the contact from the intent
        int contactNo = (Integer)getIntent().getExtras().get(EXTRA_CONTACTNO);
        Contact contact = Contact.contacts[contactNo];
        //Populate the contact image
        ImageView photo = (ImageView)findViewById(R.id.img);
        photo.setImageResource(contact.getImageResourceId());
        photo.setContentDescription(contact.getName());
        //Populate the drink name
        TextView name = (TextView)findViewById(R.id.name);
        name.setText(contact.getName());
        //Populate the contact surname
        TextView surname = (TextView)findViewById(R.id.surname);
        surname.setText(contact.getSurname());
        //Populate the contact phone number
        TextView phone = (TextView)findViewById(R.id.phone);
        phone.setText(contact.getPhone());

    }
}
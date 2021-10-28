package com.example.instruments_yourid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ContactsCategoryActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<Contact> listAdapter = new ArrayAdapter<Contact>( this, android.R.layout.simple_list_item_1, Contact.contacts);

        ListView listView = getListView();
        listView.setAdapter(listAdapter);



    }
    @Override
    public void onListItemClick(ListView listView, View itemView, int position, long id) {
        Intent intent = new Intent(ContactsCategoryActivity.this, ContactActivity.class);
        intent.putExtra(ContactActivity.EXTRA_CONTACTNO, (int) id);
        startActivity(intent);
    }

}

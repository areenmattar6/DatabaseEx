package com.mattar.areen.databaseex;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayAllContacts extends Activity {
    ListView lvContacts;
    ArrayList<Contact> ary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_contacts);
        lvContacts=findViewById(R.id.listviewcontacts);
        Dal dal=new Dal(this);
        ary=dal.getAllContacts();
        ContactAdapter ad=new ContactAdapter(this,R.layout.contact,ary);
        lvContacts.setAdapter(ad);
    }
}


package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ContactListActivity extends AppCompatActivity {
    ListView listViewContacts;
    List<Contact> contactList;
    Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        listViewContacts = findViewById(R.id.listViewContacts);
        populateContactList();
        ArrayAdapter<Contact> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contactList);
        listViewContacts.setAdapter(adapter);

        buttonBack = findViewById(R.id.listviewback);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactListActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void populateContactList() {
        contactList = new ArrayList<>();
        contactList.add(new Contact("Oussama Khlif", "93266252"));
        contactList.add(new Contact("Med Salah Touati", "95050812"));
        contactList.add(new Contact("Nedia bouhlel", "94569875"));
        contactList.add(new Contact("Semi ismaeel", "91254655"));
        contactList.add(new Contact("Salem ben Salah", "93233255"));
        contactList.add(new Contact("Yahia ben khlifa", "97597214"));
        contactList.add(new Contact("Oussama Khlif", "93266252"));
        contactList.add(new Contact("Med Salah Touati", "95050812"));
        contactList.add(new Contact("Nedia bouhlel", "94569875"));
        contactList.add(new Contact("Semi ismaeel", "91254655"));
        contactList.add(new Contact("Salem ben Salah", "93233255"));
        contactList.add(new Contact("Yahia ben khlifa", "97597214"));
    }
}


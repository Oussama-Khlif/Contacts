package com.example.contacts;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {
    ListView listViewContacts;
    ArrayList<Contact> contactList;
    Button buttonBack;
    Button action;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        listViewContacts = findViewById(R.id.listViewContacts);

        contactList = new ArrayList<>();
        contactList.add(new Contact("Oussama Khlif", "93266252"));
        contactList.add(new Contact("Med Salah Touati", "95050812"));
        contactList.add(new Contact("Ayoub Elhouche", "95050147"));
        contactList.add(new Contact("Sami ben Salah", "96035070"));
        contactList.add(new Contact("Nadia Baccouche", "99608435"));
        contactList.add(new Contact("Mouhamed Salem Housaini", "99774835"));
        contactList.add(new Contact("Jasser Baya", "55325687"));
        contactList.add(new Contact("Mouhamed Houij Bouhlel", "28147895"));
        contactList.add(new Contact("Firas Berriri", "94594789"));
        contactList.add(new Contact("Chaima Ben Abdejlil", "99774835"));
        contactList.add(new Contact("Asma Bouhlel", "55325687"));
        contactList.add(new Contact("Achraf Ladhari", "28147895"));
        contactList.add(new Contact("Amir Bouhlel", "94594789"));

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
        action = findViewById(R.id.action);
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ContactListActivity.this, ActivityAction.class);
                intent.putParcelableArrayListExtra("contactList", contactList);
                startActivity(intent);
            }
        });
    }
}


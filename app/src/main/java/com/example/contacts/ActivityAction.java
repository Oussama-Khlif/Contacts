package com.example.contacts;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ActivityAction extends AppCompatActivity {

    private ArrayList<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        contactList = getIntent().getParcelableArrayListExtra("contactList");

        Button addButton = findViewById(R.id.add);
        Button deleteButton = findViewById(R.id.delete);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameEditText = findViewById(R.id.name);
                EditText numberEditText = findViewById(R.id.numberToAdd);

                String enteredName = nameEditText.getText().toString().trim();
                String enteredNumber = numberEditText.getText().toString().trim();

                if (enteredName.isEmpty() || enteredNumber.isEmpty()) {
                    Toast.makeText(ActivityAction.this, "Veuillez entrer votre nom et votre numéro", Toast.LENGTH_SHORT).show();
                    return;
                }

                Contact newContact = new Contact(enteredName, enteredNumber);
                contactList.add(newContact);
                Toast.makeText(ActivityAction.this, "Contact ajouté avec succés", Toast.LENGTH_SHORT).show();
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nameEditText = findViewById(R.id.name);
                EditText numberEditText = findViewById(R.id.numberToAdd);
                String enteredName = nameEditText.getText().toString().trim();
                String enteredNumber = numberEditText.getText().toString().trim();

                if (enteredName.isEmpty() || enteredNumber.isEmpty()) {
                    Toast.makeText(ActivityAction.this, "Veuillez entrer votre nom et votre numéro", Toast.LENGTH_SHORT).show();
                    return;
                }

                Contact contactToDelete = new Contact(enteredName, enteredNumber);

                if (contactList.contains(contactToDelete)) {
                    contactList.remove(contactToDelete);
                    Toast.makeText(ActivityAction.this, "Contact supprimé avec succés", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ActivityAction.this, "Contact introuvable", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button buttonBack = findViewById(R.id.actionBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityAction.this, ContactListActivity.class);
                startActivity(intent);
            }
        });
    }
}

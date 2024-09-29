package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class CountryLookupActivity extends AppCompatActivity {

    private EditText editTextPhoneNumber;
    private Button buttonLookup;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_lookup);
        editTextPhoneNumber = findViewById(R.id.number);
        buttonLookup = findViewById(R.id.search);
        textViewResult = findViewById(R.id.textViewResult);
        buttonLookup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumberStr = editTextPhoneNumber.getText().toString().trim();
                String country = lookupCountry(phoneNumberStr);
                textViewResult.setText("Country: " + country);
            }
        });
        Button buttonBack = findViewById(R.id.searchBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryLookupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private String lookupCountry(String phoneNumberStr) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber phoneNumber = phoneNumberUtil.parse(phoneNumberStr, "ZZ");
            String country = phoneNumberUtil.getRegionCodeForNumber(phoneNumber);
            return country != null ? country : "Unknown";
        } catch (Exception e) {
            return "Error";
        }
    }
}
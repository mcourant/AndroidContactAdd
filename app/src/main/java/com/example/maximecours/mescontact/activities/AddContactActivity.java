package com.example.maximecours.mescontact.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maximecours.mescontact.R;

/**
 * Created by MaximeCours on 07/02/2017.
 */

public class AddContactActivity extends AppCompatActivity {

    private EditText editTextNom;
    private EditText editTextPrenom;
    private EditText editTextProfession;
    Button validate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        editTextNom = (EditText) findViewById(R.id.nameEditText);
        editTextPrenom = (EditText) findViewById(R.id.prenomEditText);
        editTextProfession = (EditText) findViewById(R.id.professionEditText);
        validate = (Button) findViewById(R.id.validateContact);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
                intent.putExtra("nom",editTextNom.getText().toString());
                intent.putExtra("prenom",editTextPrenom.getText().toString());
                intent.putExtra("profession",editTextProfession.getText().toString());
                startActivity(intent);
                finish();

            }
        });



    }
}
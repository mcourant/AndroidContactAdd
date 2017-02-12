package com.example.maximecours.mescontact.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.maximecours.mescontact.R;
import com.example.maximecours.mescontact.items.People;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by MaximeCours on 07/02/2017.
 */

public class AddContactActivity extends AppCompatActivity {

    private EditText editTextNom;
    private EditText editTextPrenom;
    private EditText editTextProfession;
    Button validate;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontact);

        editTextNom = (EditText) findViewById(R.id.nameEditText);
        editTextPrenom = (EditText) findViewById(R.id.prenomEditText);
        editTextProfession = (EditText) findViewById(R.id.professionEditText);



        if(getIntent() != null){
            Intent intent = getIntent();
            People test = (People) intent.getParcelableExtra("peopleselect");
            position = intent.getIntExtra("position",-1);
            if(test != null){
                editTextNom.setText(test.getName());
                editTextPrenom.setText(test.getPrenom());
                editTextProfession.setText(test.getProfession());
            }
        }

        validate = (Button) findViewById(R.id.validateContact);

        validate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("nom",editTextNom.getText().toString());
                intent.putExtra("prenom",editTextPrenom.getText().toString());
                intent.putExtra("profession",editTextProfession.getText().toString());
                intent.putExtra("position",position);
                setResult(Activity.RESULT_OK, intent);
                finish();

            }
        });



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddContactActivity.this, MainActivity.class);
        startActivity(intent);

    }

}

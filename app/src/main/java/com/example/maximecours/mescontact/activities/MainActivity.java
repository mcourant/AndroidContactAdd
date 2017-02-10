package com.example.maximecours.mescontact.activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.maximecours.mescontact.items.People;
import com.example.maximecours.mescontact.recyclerview.PeopleAdapter;
import com.example.maximecours.mescontact.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button ajout_contact;
    List<People> allPeopleMain = new ArrayList<>();
    private String nom;
    private String prenom;
    private String profession;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            allPeopleMain = savedInstanceState.getParcelableArrayList("LIST");
        }else{
            allPeopleMain.add(new People("EnRetard","Henrick","Pôle-Emplois"));
            allPeopleMain.add(new People("Moinet","Maxime","Mac"));
            allPeopleMain.add(new People("Pichard","Thomas","MasterOfIT"));
            allPeopleMain.add(new People("Saint-Martin","Matthieu","Ingenieur IOT"));
            allPeopleMain.add(new People("Saint-Martin","Matthieu","Ingenieur IOT"));
            allPeopleMain.add(new People("Saint-Martin","Matthieu","Ingenieur IOT"));
            allPeopleMain.add(new People("Saint-Martin","Matthieu","Ingenieur IOT"));
            allPeopleMain.add(new People("Saint-Martin","Matthieu","Ingenieur IOT"));
        }

        ajout_contact = (Button) findViewById(R.id.ajout_contact);

        ajout_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(intent);
            }
        });



        Intent intent = getIntent();
        if (intent != null) {
            Log.e("List", allPeopleMain.toString());
            allPeopleMain.add(new People(intent.getStringExtra("nom"),intent.getStringExtra("prenom"),intent.getStringExtra("profession")));
            mAdapter.notifyItemInserted(allPeopleMain.size()-1);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PeopleAdapter(allPeopleMain);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putParcelableArrayList("LIST", (ArrayList<? extends Parcelable>) allPeopleMain);
        super.onSaveInstanceState(savedInstanceState);
    }

}

package com.example.maximecours.mescontact.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.maximecours.mescontact.items.People;
import com.example.maximecours.mescontact.recyclerview.ItemTouchHelperCallback;
import com.example.maximecours.mescontact.recyclerview.PeopleAdapter;
import com.example.maximecours.mescontact.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener {

    Button ajout_contact;
    ArrayList<People> allPeopleMain = new ArrayList<>();
    private String nom;
    private String prenom;
    private String profession;

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    GestureDetector gestureDetector;

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
                startActivityForResult(intent, 1);
            }
        });



        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new PeopleAdapter(allPeopleMain);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(this);

        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent event) {
                return true;
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelperCallback((PeopleAdapter) mAdapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerView);


    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putParcelableArrayList("LIST", allPeopleMain);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)   {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK)
        {
            String nom = data.getStringExtra("nom");
            String prenom = data.getStringExtra("prenom");
            String profession = data.getStringExtra("profession");
            allPeopleMain.add(new People(nom,prenom,profession));
            mAdapter.notifyDataSetChanged();
        }
    }





    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

        if (gestureDetector.onTouchEvent(e)){
            View child = mRecyclerView.findChildViewUnder(e.getX(),e.getY());
            if(child != null){
                int position = mRecyclerView.getChildAdapterPosition(child);
                Toast.makeText(this, ""+position, Toast.LENGTH_SHORT).show();
                return true;
            }
        }
        return false;

    }



    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}

package com.example.maximecours.mescontact.recyclerview;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.maximecours.mescontact.R;
import com.example.maximecours.mescontact.items.People;

import java.util.List;

/**
 * Created by MaximeCours on 07/02/2017.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleViewHolder> {

    private List<People> allPeople;

    public PeopleAdapter(List<People> allPeople){
        this.allPeople = allPeople;
    }

    @Override
    public PeopleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewName = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_contact, parent, false);
        return new PeopleViewHolder(viewName);
    }

    @Override
    public void onBindViewHolder(PeopleViewHolder holder, int position) {
        holder.getFullName().setText(allPeople.get(position).getFullName());
        holder.getText_profession().setText(allPeople.get(position).getProfession());
    }

    @Override
    public int getItemCount() {
        return allPeople.size();
    }

    public void onItemDismiss(int position){
        if(position > -1){
            allPeople.remove(position);
            notifyItemRemoved(position);
        }
    }
}

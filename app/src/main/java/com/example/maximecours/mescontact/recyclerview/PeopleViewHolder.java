package com.example.maximecours.mescontact.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.maximecours.mescontact.R;

import org.w3c.dom.Text;

/**
 * Created by MaximeCours on 07/02/2017.
 */

public class PeopleViewHolder extends RecyclerView.ViewHolder {

        private TextView text_full_name;
        private TextView text_profession;

        public PeopleViewHolder(View itemView) {
            super(itemView);
            text_full_name = (TextView) itemView.findViewById(R.id.fullnameTextView);
            text_profession = (TextView) itemView.findViewById(R.id.professionTextView);
        }

    public TextView getFullName(){
        return text_full_name;
    }

    public TextView getText_profession() {
        return text_profession;
    }
}


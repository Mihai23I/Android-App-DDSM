package com.mi23.ddsmappmci.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mi23.ddsmappmci.R;

import java.util.ArrayList;

import Model.MessageNotebook;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    TextView txtMessage;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        txtMessage = itemView.findViewById(R.id.txt_message);
    }
}
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

public class CustomRecycleAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    Context c;
    ArrayList<MessageNotebook> message;

    public CustomRecycleAdapter(Context c, ArrayList<MessageNotebook> message) {
        this.c = c;
        this.message = message;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(c).inflate(R.layout.notebook_recycle_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        MessageNotebook m = message.get(position);

        holder.txtMessage.setText(m.getMessage());
    }

    @Override
    public int getItemCount() {
        return message.size();
    }
}

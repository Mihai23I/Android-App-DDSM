package com.mi23.ddsmappmci.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mi23.ddsmappmci.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{
    String data1[];
    int images[];
    Context context;

    public HomeAdapter(Context c, String s1[], int imgs[]){
        context = c;
        data1 = s1;
        images = imgs;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.home_row, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.recText.setText(data1[position]);
        holder.recImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {

        TextView recText;
        ImageView recImage;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            recText = itemView.findViewById(R.id.recTxtView);
            recImage = itemView.findViewById(R.id.recImView);
        }
    }
}

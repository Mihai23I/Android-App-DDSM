package com.mi23.ddsmappmci.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mi23.ddsmappmci.R;

import java.util.ArrayList;

import Model.MessageNotebook;

public class CustomAdapter extends BaseAdapter {
    Context c;
    ArrayList<MessageNotebook> message;

    public CustomAdapter(Context c, ArrayList<MessageNotebook> message) {
        this.c = c;
        this.message = message;
    }

    @Override
    public int getCount() {
        return message.size();
    }

    @Override
    public Object getItem(int i) {
        return message.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.notebook_recycle_item, viewGroup, false);

        TextView txtMessage;
        txtMessage = view.findViewById(R.id.txt_message);

        MessageNotebook m = (MessageNotebook) this.getItem(i);
        txtMessage.setText(m.getMessage());

        return view;
    }
}

package com.mi23.ddsmappmci.ui.sharesheet;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mi23.ddsmappmci.R;

public class SharesheetFragment extends Fragment {

    private SharesheetViewModel mViewModel;
    private Button shareTxtBtn;
    private TextView textView;
    private EditText textSend;

    public SharesheetFragment() {
    }

    public static SharesheetFragment newInstance() {
        return new SharesheetFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.sharesheet_fragment, container, false);
        shareTxtBtn = view.findViewById(R.id.shareTxtBtn);
        textView = view.findViewById(R.id.textView2);
        textSend = view.findViewById(R.id.textSend);

        shareTxtBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
//                sendIntent.setType("text/plain");
//
//                Intent shareIntent = Intent.createChooser(sendIntent, null);
//                startActivity(shareIntent);


                String text = textSend.getText().toString();
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "This is the spreadsheet message");
                sharingIntent.putExtra(Intent.EXTRA_TEXT, text);
                startActivity(Intent.createChooser(sharingIntent, "Share text via"));
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SharesheetViewModel.class);
        // TODO: Use the ViewModel
    }

}
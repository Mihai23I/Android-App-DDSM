package com.mi23.ddsmappmci.ui.sharesheet;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mi23.ddsmappmci.R;

public class SharesheetFragment extends Fragment {

    private SharesheetViewModel mViewModel;

    public static SharesheetFragment newInstance() {
        return new SharesheetFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sharesheet_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SharesheetViewModel.class);
        // TODO: Use the ViewModel
    }

}
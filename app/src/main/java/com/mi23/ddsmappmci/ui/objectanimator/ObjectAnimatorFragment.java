package com.mi23.ddsmappmci.ui.objectanimator;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mi23.ddsmappmci.R;

public class ObjectAnimatorFragment extends Fragment {

    private ObjectAnimatorViewModel mViewModel;

    public static ObjectAnimatorFragment newInstance() {
        return new ObjectAnimatorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.object_animator_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ObjectAnimatorViewModel.class);
        // TODO: Use the ViewModel
    }

}
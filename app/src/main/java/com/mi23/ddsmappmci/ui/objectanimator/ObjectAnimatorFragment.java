package com.mi23.ddsmappmci.ui.objectanimator;

import androidx.lifecycle.ViewModelProvider;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.mi23.ddsmappmci.R;

import java.util.Random;

public class ObjectAnimatorFragment extends Fragment {

    private ObjectAnimatorViewModel mViewModel;
    private ImageView car_animated;
    private Button btn_object_animator;

    public static ObjectAnimatorFragment newInstance() {
        return new ObjectAnimatorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.object_animator_fragment, container, false);
        car_animated = view.findViewById(R.id.car_animated);
        btn_object_animator = view.findViewById(R.id.btn_object_animator);
        btn_object_animator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimatorSet animator = new AnimatorSet();

                Random rd = new Random(); // creating Random object

                ObjectAnimator x = ObjectAnimator.ofFloat(car_animated, "translationX", rd.nextFloat() * 700 - 350);
                ObjectAnimator y = ObjectAnimator.ofFloat(car_animated, "translationY", rd.nextFloat() * 700 - 350);
                animator.playTogether(x, y);
                animator.setInterpolator(new LinearInterpolator());
                animator.setDuration(1500);
                animator.start();
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ObjectAnimatorViewModel.class);
        // TODO: Use the ViewModel
    }

}
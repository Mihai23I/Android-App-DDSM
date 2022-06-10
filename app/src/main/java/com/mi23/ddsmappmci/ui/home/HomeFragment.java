package com.mi23.ddsmappmci.ui.home;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mi23.ddsmappmci.CustomAdapter.HomeAdapter;
import com.mi23.ddsmappmci.R;
import com.mi23.ddsmappmci.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    RecyclerView recyclerView;
    int images[];
    String s1[];
    ImageView unibuc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        images = new int[]{R.drawable.ic_baseline_photo_camera_24, R.drawable.ic_search,
                        R.drawable.ic_baseline_navigation_24, R.drawable.ic_baseline_book_24,
                        R.drawable.ic_baseline_share_24, R.drawable.ic_baseline_notifications_active_24,
                        R.drawable.ic_baseline_map_24, R.drawable.ic_baseline_arrow_upward_24,
                        R.drawable.ic_baseline_login_24, R.drawable.ic_baseline_data_usage_24,
                        R.drawable.ic_baseline_video_library_24, R.drawable.ic_baseline_phone_android_24};

        s1 = getResources().getStringArray(R.array.home_page);
        recyclerView = view.findViewById(R.id.recyclerview);
        unibuc = view.findViewById(R.id.unibuc);

        HomeAdapter adapter = new HomeAdapter(getActivity(), s1, images);
        recyclerView.setAdapter(adapter);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
            unibuc.setVisibility(View.INVISIBLE);
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            unibuc.setVisibility(View.VISIBLE);
        }


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
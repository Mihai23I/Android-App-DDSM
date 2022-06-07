package com.mi23.ddsmappmci.ui.youtube;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mi23.ddsmappmci.MainActivity;
import com.mi23.ddsmappmci.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import static io.realm.Realm.getApplicationContext;

public class YoutubeFragment extends Fragment {

    private YoutubeViewModel mViewModel;
    private YouTubePlayerView youTubePlayerView;
    private Button button_ytb;
    private EditText edit_ytb_id;

    public static YoutubeFragment newInstance() {
        return new YoutubeFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.youtube_fragment, container, false);
        button_ytb = view.findViewById(R.id.button_ytb);
        edit_ytb_id = view.findViewById(R.id.edit_ytb_id);
        youTubePlayerView = view.findViewById(R.id.youTube_player);
        getLifecycle().addObserver(youTubePlayerView);

        button_ytb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.getYouTubePlayerWhenReady(youTubePlayer -> {
                    String ytb_id = edit_ytb_id.getText().toString();
                    Toast.makeText(getActivity(), ytb_id, Toast.LENGTH_SHORT).show();
                    youTubePlayer.loadVideo(ytb_id, 0); });
            }
        });


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(YoutubeViewModel.class);
        // TODO: Use the ViewModel
    }

}
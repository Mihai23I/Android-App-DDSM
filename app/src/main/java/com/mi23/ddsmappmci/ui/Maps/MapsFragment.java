package com.mi23.ddsmappmci.ui.Maps;

import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mi23.ddsmappmci.R;

public class MapsFragment extends Fragment implements OnMapReadyCallback{

    private MapsViewModel mViewModel;

    public static MapsFragment newInstance() {
        return new MapsFragment();
    }

    private MapView mapView;
    private GoogleMap googleMap;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.maps_fragment, container, false);

        return view;
        //44.435578, 26.099525
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = (MapView) view.findViewById(R.id.maps);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MapsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onMapReady(@NonNull GoogleMap map) {
        googleMap = map;

        LatLng Unibuc = new LatLng(44.435601, 26.100917);
        googleMap.addMarker(new MarkerOptions().position(Unibuc).title("Unibuc"));
        googleMap.addMarker(new MarkerOptions().position(new LatLng(44.427500, 26.087500)).title("Palatul Parlamentului"));

        googleMap.addCircle(new CircleOptions().center(Unibuc).radius(100));


//        googleMap.addGroundOverlay(
//                new GroundOverlayOptions()
//                        .position(new LatLng(44.427500, 26.087500), 100f, 100f)
//                        .image()
//                        .clickable(true)
//        )

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(Unibuc));
        googleMap.setMinZoomPreference(15.0f);
        this.googleMap = googleMap;
    }

}
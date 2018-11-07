package com.wedapp.sud.myapp2;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ContactFragment extends Fragment {
    MapView mapView;
    GoogleMap googleMap;
    public ContactFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact_fragment, container, false);
        mapView = (MapView) view.findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        String title;
        if (mapView != null) {
            LatLng mylocation;
            TextView address = (TextView) view.findViewById(R.id.contact_us);
            TextView heading = (TextView) view.findViewById(R.id.fragHead);
            TextView timming = (TextView) view.findViewById(R.id.fragTim);
            TextView date    = (TextView) view.findViewById(R.id.fragDate);
            String parent = getArguments().getString("parent");
            if (parent.equals("reception")){
                mylocation = new LatLng(19.014045, 73.037912);
                address.setText(R.string.recpt_add);
                heading.setText(R.string.title_activity_display_reception);
                timming.setText(R.string.Recpt_Tim);
                date.setText(R.string.Recp_date);
                title = "Marker in Sutra Benquet";
            }else {
                mylocation = new LatLng(17.680506, 74.017424);
                address.setText(R.string.wedadd_line);
                heading.setText(R.string.title_activity_dispay_wedding);
                timming.setText(R.string.Wedd_Tim);
                date.setText(R.string.Wedd_date);
                title = "Marker in Hotel Lake view";
            }
            googleMap = mapView.getMap();
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            googleMap.addMarker(new MarkerOptions().position(mylocation).title(title));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom( new LatLng(mylocation.latitude, mylocation.longitude) , 12.0f));
            googleMap.isTrafficEnabled();
            googleMap.setBuildingsEnabled(true);

            if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return view;
            }
            googleMap.setMyLocationEnabled(true);
            googleMap.getUiSettings().setZoomControlsEnabled(true);
            MapsInitializer.initialize(this.getActivity());
        }
        return view;
    }
    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
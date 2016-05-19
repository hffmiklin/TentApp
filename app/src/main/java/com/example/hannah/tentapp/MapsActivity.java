package com.example.hannah.tentapp;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;


import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends AppCompatActivity
        implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {


    private static final int ERROR_DIALOG_REQUEST = 9001;
    private GoogleMap mMap;
    private static final double
            FORSKNINGSGANGEN_LAT = 57.706176,
            FORSKNINGSGANGEN_LNG = 11.936952;

    private GoogleApiClient mLocationClient;
    private com.google.android.gms.location.LocationListener mListener;
    LatLng latLng;
    Marker mCurrLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (servicesOK()) {
            setContentView(R.layout.activity_maps);

            if (initMap()) {
                Toast.makeText(this, "Bygger karta", Toast.LENGTH_SHORT).show();
                goToLocation(FORSKNINGSGANGEN_LAT, FORSKNINGSGANGEN_LNG, 15);


                mLocationClient = new GoogleApiClient.Builder(this)
                        .addApi(LocationServices.API)
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)

                        .build();

                mLocationClient.connect();

            } else {
                Toast.makeText(this, "Kunde ej nå karta", Toast.LENGTH_SHORT).show();
            }


        } else {
            setContentView(R.layout.activity_maps);

        }
    }

    private boolean initMap() {
        if (mMap == null) {
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
            mMap = mapFragment.getMap();
        }
        return (mMap != null);
    }


    private void goToLocation(double lat, double lng, float zoom) {
        LatLng latLng = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(latLng, zoom);
        mMap.moveCamera(update);

    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    public void onSearch(View view) {
        EditText location_tf = (EditText) findViewById(R.id.TFaddress);
        String location = location_tf.getText().toString();
        List<Address> addressList = null;
        if (!(location == null || location.equals(""))) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            if (addressList.size() > 0){
                Address address = addressList.get(0);
                LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));

                InputMethodManager inputMgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                EditText editText = (EditText) findViewById(R.id.TFaddress);
                inputMgr.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(57.706380, 11.938502)).title("marker"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);
    }

    public boolean servicesOK() {
        int isAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        if (isAvailable == ConnectionResult.SUCCESS) {
            return true;
        } else if (GooglePlayServicesUtil.isUserRecoverableError(isAvailable)) {
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(isAvailable, this, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast.makeText(this, "Kunde ej ansluta till karttjänsten", Toast.LENGTH_SHORT).show();
        }

        return false;

    }

    private void hideSoftKeyboard(View v) {
        InputMethodManager imm =
                (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromInputMethod(v.getWindowToken(), 0);
    }

    public void geoLocate(View v) throws IOException {

        hideSoftKeyboard(v);

        TextView tv = (TextView) findViewById(R.id.TFaddress);
        String searchString = tv.getText().toString();
        Toast.makeText(this, "Söker efter: " + searchString, Toast.LENGTH_SHORT).show();

        Geocoder gc = new Geocoder(this);

        List<Address> list = gc.getFromLocationName(searchString, 1);

        if (list.size() > 0) {
            Address add = list.get(0);
            String locality = add.getLocality();
            Toast.makeText(this, "Hittade> " + locality, Toast.LENGTH_SHORT).show();

            double lat = add.getLatitude();
            double lng = add.getLongitude();

            goToLocation(lat, lng, 15);

        }
    }

    public void showCurrentLocation(View v) {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location currentLocation = LocationServices.FusedLocationApi
                .getLastLocation(mLocationClient);
        if (currentLocation == null) {
            Toast.makeText(this, "Kunde ej ansluta!", Toast.LENGTH_SHORT).show();
        } else {
            LatLng latlng = new LatLng(
                    currentLocation.getLatitude(),
                    currentLocation.getLongitude()
            );
            CameraUpdate update = CameraUpdateFactory.newLatLngZoom(
                    latlng, 15
            );
            mMap.animateCamera(update);
            hideSoftKeyboard(v);
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        Toast.makeText(this, "Bygger karta", Toast.LENGTH_SHORT).show();



        Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(
                mLocationClient);
        if (mLastLocation != null) {
            //place marker at current position
            mMap.clear();
            latLng = new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("Current Position");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
            mCurrLocation = mMap.addMarker(markerOptions);
        }
        mListener = new com.google.android.gms.location.LocationListener()
        {
            @Override
            public void onLocationChanged(Location location) {
                Toast.makeText(MapsActivity.this,
                        "Plats ändrad: " + location.getLatitude() + " , "
                                + location.getLongitude(), Toast.LENGTH_SHORT).show();

                goToLocation(location.getLatitude(), location.getLongitude(), 15);

            }
        };
        LocationRequest request = LocationRequest.create();
        request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        request.setInterval(60000);
        request.setFastestInterval(5000);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mLocationClient, request, mListener
        );
        }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        LocationServices.FusedLocationApi.removeLocationUpdates(
                mLocationClient, mListener
        );
    }


}

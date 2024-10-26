package com.example.lgreen;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class NoticeDetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private String address;
    private String quantity;
    private String points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        ImageView back = findViewById(R.id.back_notify);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NoticeDetailActivity.this, NoticeFormActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();
        address = intent.getStringExtra("address");
        quantity = intent.getStringExtra("quantity");
        points = intent.getStringExtra("points");
        int imageResId = intent.getIntExtra("imageResId", -1);

        TextView contentTextView = findViewById(R.id.tv_notice_detail_content);
        TextView addressTextView = findViewById(R.id.tv_notice_detail_address);
        TextView quantityTextView = findViewById(R.id.tv_notice_detail_quantity);
        TextView pointsTextView = findViewById(R.id.tv_notice_detail_points);
        ImageView detailImageView = findViewById(R.id.iv_notice_detail_image);

        if (!TextUtils.isEmpty(address)) {
            addressTextView.setText("Address: " + address);
        }

        if (!TextUtils.isEmpty(quantity)) {
            quantityTextView.setText("Quantity: " + quantity);
        }

        if (!TextUtils.isEmpty(points)) {
            pointsTextView.setText("Points: " + points);
        }

        if (imageResId != -1) {
            detailImageView.setImageResource(imageResId);
        }

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_view);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap map) {
        googleMap = map;
        loadLocationOnMap(address);
    }

    private void loadLocationOnMap(String location) {
        if (googleMap != null && location != null && !location.isEmpty()) {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            try {
                List<Address> addressList = geocoder.getFromLocationName(location, 1);
                if (addressList != null && !addressList.isEmpty()) {
                    Address address = addressList.get(0);
                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());

                    googleMap.addMarker(new MarkerOptions().position(latLng).title(location));
                    googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class ProveedoresActivity extends AppCompatActivity {

    Button AgregarProv;
    EditText direccionProveedor, nombreProveedor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        direccionProveedor = findViewById(R.id.direccion_proveedor);
        nombreProveedor = findViewById(R.id.nombre_proveedor);
        AgregarProv = findViewById(R.id.agregar_btn);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapita);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {

            }
        });

        AgregarProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String direccionProv = direccionProveedor.getText().toString();
                String nombreProv = nombreProveedor.getText().toString();


            }
        });
    }
}
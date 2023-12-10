package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    Button AgregarProv, BotonRegresar;
    EditText puntito1;
    EditText puntito2;
    EditText puntito3;
    EditText puntito4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proveedores);

        puntito1 = findViewById(R.id.puntito1);
        puntito2 = findViewById(R.id.puntito2);
        puntito3 = findViewById(R.id.puntito3);
        puntito4 = findViewById(R.id.puntito4);
        AgregarProv = findViewById(R.id.agregar_btn);
        BotonRegresar = findViewById(R.id.btnregreso);


        BotonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        MainActivity.class
                );
                startActivity(intent);
            }
        });

        AgregarProv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        GoogleMaps.class
                );

                String cadena1 = (puntito1.getText().toString());
                String[] partesuno = cadena1.split(",");
                String partelongituduna = partesuno[0];
                String partelatituduna = partesuno[1];

                String cadena2 = (puntito2.getText().toString());
                String[] partesdos = cadena2.split(",");
                String partelongituddos = partesdos[0];
                String partelatituddos = partesdos[1];

                String cadena3 = (puntito3.getText().toString());
                String[] partestres = cadena3.split(",");
                String partelongitudtres = partestres[0];
                String partelatitudtres = partestres[1];

                String cadena4 = (puntito4.getText().toString());
                String[] partescuatro = cadena4.split(",");
                String partelongitudcuatro = partescuatro[0];
                String partelatitudcuatro = partescuatro[1];

                double primeralong = Double.parseDouble(partelongituduna.toString());
                double primeralati = Double.parseDouble(partelatituduna.toString());
                double segundalong = Double.parseDouble(partelongituddos.toString());
                double segundalati = Double.parseDouble(partelatituddos.toString());
                double terceralong = Double.parseDouble(partelongitudtres.toString());
                double terceralati = Double.parseDouble(partelatitudtres.toString());
                double cuartalong = Double.parseDouble(partelongitudcuatro.toString());
                double cuartalati = Double.parseDouble(partelatitudcuatro.toString());

                intent.putExtra("lo1", primeralong);
                intent.putExtra("la1", primeralati);
                intent.putExtra("lo2", segundalong);
                intent.putExtra("la2", segundalati);
                intent.putExtra("lo3", terceralong);
                intent.putExtra("la3", terceralati);
                intent.putExtra("lo4", cuartalong);
                intent.putExtra("la4", cuartalati);

                intent.putExtra("Agregar",AgregarProv.getText().toString());
                startActivity(intent);

            }
        });
    }}
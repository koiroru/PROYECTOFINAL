package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton agregarinsumo;
    Button Proveedor;
    Button Fijos;
    Button Inicios;
    Button Variable;
    Button Calculadora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        agregarinsumo = findViewById(R.id.fab);
        Proveedor = findViewById(R.id.prov);
        Fijos = findViewById(R.id.fijo);
        Inicios = findViewById(R.id.inicio);
        Variable = findViewById(R.id.var);
        Calculadora = findViewById(R.id.cal);

        agregarinsumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AgregarInsumosActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Proveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProveedoresActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Fijos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FijoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Inicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Variable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VariableActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalculadoraActivity.class);

                startActivity(intent);
                finish();
            }
        });
    }
}

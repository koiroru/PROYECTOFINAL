package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculadoraActivity extends AppCompatActivity {
    EditText editTextCostoProduccion, editTextNumUnidades, editTextCostoManoObra;
    TextView textViewResultado;
    Button BotonCalcular, BotonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        editTextCostoProduccion = findViewById(R.id.agregamaterial);
        editTextNumUnidades = findViewById(R.id.agregaunidades);
        editTextCostoManoObra = findViewById(R.id.agregamano);
        textViewResultado = findViewById(R.id.textResultado);
        BotonCalcular = findViewById(R.id.btncalcular);
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
        BotonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularCostoUnitario();
            }
        });
    }
        public void calcularCostoUnitario (){
            try {
                double costoProduccion = Double.parseDouble(editTextCostoProduccion.getText().toString());
                int numUnidades = Integer.parseInt(editTextNumUnidades.getText().toString());
                double costoManoObra = Double.parseDouble(editTextCostoManoObra.getText().toString());

                double costoTotalProduccion = costoProduccion + costoManoObra;
                double costoUnitario = costoTotalProduccion / numUnidades;

                textViewResultado.setText("$  " + costoUnitario);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Ingrese valores válidos en los campos", Toast.LENGTH_SHORT).show();
            }
        }


    }

package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class MainActivity extends AppCompatActivity {

    private List<Insumos> ListInsumos = new ArrayList<Insumos>();
    ArrayAdapter<Insumos> arrayAdapterInsumos;
    EditText eTNombre,eTValor;
    Button bTAgregar;
    ListView lvListadoInsumos;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Button Proveedor;
    Button Fijos;
    Button Inicios;
    Button Variable;
    Button Calculadora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Proveedor = findViewById(R.id.prov);
        Fijos = findViewById(R.id.fijo);
        Inicios = findViewById(R.id.inicio);
        Variable = findViewById(R.id.var);
        Calculadora = findViewById(R.id.cal);

        eTNombre=findViewById(R.id.agreganombre);
        eTValor=findViewById(R.id.agregarvalor);
        bTAgregar=findViewById(R.id.btnagregar);

        lvListadoInsumos=findViewById(R.id.listviewInsumos);
        inicializarFireBase();
        listarDatos();
        bTAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Insumos insumos = new Insumos();

                insumos.setNombre(eTNombre.getText().toString());
                insumos.setValor(eTValor.getText().toString());
                databaseReference.child("Insumos").child(insumos.getNombre()).setValue(insumos);
            }
        });
    }
    private void listarDatos() {
            databaseReference.child("Insumos").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ListInsumos.clear();
                    for (DataSnapshot objs : snapshot.getChildren()){
                        Insumos li =objs.getValue(Insumos.class);
                        ListInsumos.add(li);
                        arrayAdapterInsumos =new ArrayAdapter<Insumos>(MainActivity.this, android.R.layout.simple_expandable_list_item_1,ListInsumos);
                        lvListadoInsumos.setAdapter(arrayAdapterInsumos);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

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
    private void inicializarFireBase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase =FirebaseDatabase.getInstance();
        databaseReference =firebaseDatabase.getReference();
    }
}


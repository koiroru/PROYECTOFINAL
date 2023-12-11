package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

    private ArrayList insumos;
    private ArrayAdapter adaptador1;
    private ListView lv1;
    EditText eTNombre, eTValor;
    Button bTAgregar;
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

        eTNombre = findViewById(R.id.agreganombre);
        eTValor = findViewById(R.id.agregarvalor);
        bTAgregar = findViewById(R.id.btnagregar);

        insumos = new ArrayList();
        insumos.add("Nombre: Papel - Valor:  $15000");
        insumos.add("Nombre: Opalinas - Valor:  $10000");
        insumos.add("Nombre: Silicona - Valor:  $5000");
        insumos.add("Nombre: Rosas - Valor:  $1000");
        insumos.add("Nombre: Cinta - Valor:  $7000");
        insumos.add("Nombre: Perlas - Valor:  $6000");

        adaptador1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, insumos);
        lv1 = findViewById(R.id.listviewInsumos);
        lv1.setAdapter(adaptador1);
        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion = i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
                dialogo1.setTitle("Importante");
                dialogo1.setMessage("¿ Desea eliminar este Insumo ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        insumos.remove(posicion);
                        adaptador1.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });


        bTAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insumos.add(eTNombre.getText().toString());
                insumos.add(eTValor.getText().toString());
                adaptador1.notifyDataSetChanged();
                eTNombre.setText("");
                eTValor.setText("");
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



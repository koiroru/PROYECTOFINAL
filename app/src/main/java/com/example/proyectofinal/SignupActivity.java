package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    EditText registroNombre, registroEmail, registroUsername, registroPassword;
    TextView inicioRedText;
    Button registroBtn;

    //aqui tambien HAY QUE AGREGAR FIREBASEEE NO ENTIENDOOOO
    //    FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        registroNombre = findViewById(R.id.registro_nombre);
        registroEmail = findViewById(R.id.registro_email);
        registroUsername = findViewById(R.id.registro_usuario);
        registroPassword = findViewById(R.id.registro_password);
        registroBtn = findViewById(R.id.registro_btn);
        inicioRedText = findViewById(R.id.ingreso_RedText);

        registroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //aqui deberia estar lo de firebase pero no lo entiendo :p

                String name = registroNombre.getText().toString();
                String email = registroEmail.getText().toString();
                String username = registroUsername.getText().toString();
                String password = registroPassword.getText().toString();

                //HelperClass helperClass = new HelperClass(name, email, username, password);
                //no entiendo mucho AYUDAAAAAAAA

                Toast.makeText(SignupActivity.this, "El registro ha sido exitoso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        inicioRedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        }
}
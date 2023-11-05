package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    Button ingresobtn;
    EditText ingresoEmail, ingresoPassword;
    FirebaseAuth mAuth;
    TextView registroRedText;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();

        ingresoEmail = findViewById(R.id.inicio_email);
        ingresoPassword = findViewById(R.id.inicio_password);
        ingresobtn = findViewById(R.id.inicio_btn);
        registroRedText = findViewById(R.id.registro_RedText);

        ingresobtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                String  ingEmail, ingPassword;

                ingEmail = String.valueOf(ingresoEmail.getText());
                ingPassword = String.valueOf(ingresoPassword.getText());


                if (TextUtils.isEmpty(ingEmail)) {
                    Toast.makeText(LoginActivity.this, "Ingresa un email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(ingPassword)) {
                    Toast.makeText(LoginActivity.this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(ingEmail, ingPassword)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "Bienvenido a Mi valor Agregado",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {

                                    Toast.makeText(LoginActivity.this, "Problemas con el ingreso, espera un poco",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
        registroRedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }



}






package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;




public class SignupActivity extends AppCompatActivity {

    EditText registroEmail, registroPassword;
    TextView inicioRedText;
    Button registroBtn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        registroEmail = findViewById(R.id.registro_email);
        registroPassword = findViewById(R.id.registro_password);
        registroBtn = findViewById(R.id.registro_btn);

        inicioRedText = findViewById(R.id.ingreso_RedText);

        registroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String  emailUser, passUser;

                emailUser = String.valueOf(registroEmail.getText());
                passUser = String.valueOf(registroPassword.getText());


                if (TextUtils.isEmpty(emailUser)) {
                    Toast.makeText(SignupActivity.this, "Ingresa un email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(passUser)) {
                    Toast.makeText(SignupActivity.this, "Ingresa una contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(emailUser, passUser)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(SignupActivity.this, "El registro fue exitoso",
                                            Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                } else {

                                    Toast.makeText(SignupActivity.this, "Tenemos un problema con el registro",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        inicioRedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}



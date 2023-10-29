package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText ingresoUsername, ingresoPassword;
    Button ingresoBtn;
    TextView registroRedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ingresoUsername = findViewById(R.id.inicio_usuario);
        ingresoPassword = findViewById(R.id.inicio_password);
        registroRedText = findViewById(R.id.registro_RedText);
        ingresoBtn = findViewById(R.id.inicio_btn);

        ingresoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

          //      if (!validarUsuario() | !validarPassword()) {

           //     } else {
                    // aqui va un check de los datos :D
                    // checkUser();
                }
          //  }
        });
        registroRedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

  //  public Boolean validarUsuario() {
    //    String val = ingresoUsername.getText().toString();
     //   if (val.isEmpty()) {
      //      ingresoUsername.setError("El usuario no puede estar vacío");
       //     return false;
       // } else {
        //    ingresoUsername.setError(null);
         //   return true;
       // }
    //}

    //public Boolean validarPassword() {
      //  String val = ingresoPassword.getText().toString();
       // if (val.isEmpty()) {
        //    ingresoPassword.setError("El password no puede estar vacío");
         //   return false;
        //} else {
         //   ingresoPassword.setError(null);
          //  return true;
        //}
    //}
}
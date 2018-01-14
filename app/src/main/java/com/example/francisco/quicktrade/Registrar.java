package com.example.francisco.quicktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registrar extends AppCompatActivity {

    private Button enviar, volver;
    private EditText usuario, nombre, apellidos, direccion, correo;
    DatabaseReference bbdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        enviar = (Button) findViewById(R.id.btnEnviar);
        volver = (Button) findViewById(R.id.btnVolver);
        usuario = (EditText) findViewById(R.id.txtUsuario);
        nombre = (EditText) findViewById(R.id.txtNombre);
        apellidos = (EditText) findViewById(R.id.txtApellido);
        direccion = (EditText) findViewById(R.id.txtDireccion);
        correo = (EditText) findViewById(R.id.txtCorreo);

        bbdd = FirebaseDatabase.getInstance().getReference("usuarios");

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            Usuario user = new Usuario(nombre.getText().toString(), correo.getText().toString(),
                    direccion.getText().toString(),apellidos.getText().toString());

            bbdd.child(usuario.getText().toString()).setValue(user);

                Toast.makeText(Registrar.this, "usuario añadido con exito", Toast.LENGTH_SHORT).show();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}

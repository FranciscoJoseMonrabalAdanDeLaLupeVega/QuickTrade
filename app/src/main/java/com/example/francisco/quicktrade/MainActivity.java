package com.example.francisco.quicktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button registrar, verUsuario, modUsuario, verProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = (Button) findViewById(R.id.btnRegistrar);
        verUsuario = (Button) findViewById(R.id.btnModUser);
        modUsuario = (Button) findViewById(R.id.btnVerUser);
        verProductos = (Button) findViewById(R.id.btnVerProductos);
        registrar.setOnClickListener(this);
        verUsuario.setOnClickListener(this);
        modUsuario.setOnClickListener(this);
        verProductos.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnRegistrar) {
            Intent i = new Intent(this, Registrar.class);
            startActivity(i);
        } else {
            if (v.getId() == R.id.btnModUser) {
                Intent i = new Intent(this, ModUser.class);
                startActivity(i);
            } else {
                if (v.getId() == R.id.btnVerUser) {
                    Intent i = new Intent(this, VerUser.class);
                    startActivity(i);
                } else {
                    if (v.getId() == R.id.btnVerProductos) {
                        Intent i = new Intent(this, Productos.class);
                        startActivity(i);
                    }
                }
            }
        }
    }
}

package com.example.francisco.quicktrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Productos extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference bbdd;
    private ListView lista;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> productosList;
    private Button btnMisProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        btnMisProductos = (Button) findViewById(R.id.btnMisProductos);
        btnMisProductos.setOnClickListener(this);

        lista = (ListView) findViewById(R.id.listaProductos);
        bbdd = FirebaseDatabase.getInstance().getReference("productos");
        productosList = new ArrayList<String>();

        bbdd.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {

                    Producto producto = dataSnapshot1.getValue(Producto.class);
                    productosList.add(producto.getName());

                    adapter = new ArrayAdapter<String>(Productos.this, android.R.layout.simple_list_item_1, productosList);
                    lista.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnMisProductos) {

            Intent i = new Intent(Productos.this, MisProductos.class);
            startActivity(i);
        }
    }
}

package com.example.francisco.quicktrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VerUser extends AppCompatActivity {

    private DatabaseReference bbdd;
    private ListView lista;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> usuariosList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_user);

        lista = (ListView) findViewById(R.id.listaUsers);
        bbdd = FirebaseDatabase.getInstance().getReference("usuarios");
        usuariosList = new ArrayList<String>();

        bbdd.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {

                    Usuario user = dataSnapshot1.getValue(Usuario.class);
                    usuariosList.add(user.getNombre());

                    adapter = new ArrayAdapter<String>(VerUser.this, android.R.layout.simple_list_item_1, usuariosList);
                    lista.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

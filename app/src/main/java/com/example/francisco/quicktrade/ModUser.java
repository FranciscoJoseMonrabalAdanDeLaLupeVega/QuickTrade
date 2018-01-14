package com.example.francisco.quicktrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ModUser extends AppCompatActivity {

    private EditText nombre, correo, apellido, direccion;
    private Button enviar;
    DatabaseReference bbdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_user);

        enviar = (Button) findViewById(R.id.btnModEnviar);
        nombre = (EditText) findViewById(R.id.txtModName);
        apellido = (EditText) findViewById(R.id.txtModApellido);
        correo = (EditText) findViewById(R.id.txtModCorreo);
        direccion = (EditText) findViewById(R.id.txtModDireccion);

        bbdd = FirebaseDatabase.getInstance().getReference("usuarios");

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!TextUtils.isEmpty(nombre.getText().toString())){
                    Query q = bbdd.orderByChild("nombre").equalTo(nombre.getText().toString());

                    q.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for(DataSnapshot datasnapshot: dataSnapshot.getChildren()){
                                String clave=datasnapshot.getKey();
                                
                                if(!TextUtils.isEmpty(apellido.getText().toString()))
                                    bbdd.child(clave).child("apellido").setValue(apellido.getText().toString());
                                if(!TextUtils.isEmpty(correo.getText().toString()))
                                    bbdd.child(clave).child("correo").setValue(correo.getText().toString());
                                if(!TextUtils.isEmpty(direccion.getText().toString()))
                                    bbdd.child(clave).child("direccion").setValue(direccion.getText().toString());
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    Toast.makeText(ModUser.this, "El disco "+nombre.getText().toString()+" se ha modificado con éxito", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(ModUser.this, "Debes de introducir un título", Toast.LENGTH_LONG).show();
                }

            }
        });



    }
}

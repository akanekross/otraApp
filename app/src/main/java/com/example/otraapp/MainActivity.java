package com.example.otraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.otraapp.Modelo.Alumno;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    Button btnAgregar;
    EditText etNombre,etApellido,etEdad,etRut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre=(EditText) findViewById(R.id.etNombre);
        etApellido=(EditText) findViewById(R.id.etApellido);
        etEdad=(EditText) findViewById(R.id.etEdad);
        etRut=(EditText) findViewById(R.id.etRut);
        btnAgregar = (Button) findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "HOLA XD", Toast.LENGTH_SHORT).show();
                insertar();
            }
        });
    }
    public void insertar(){
        String rut = etRut.getText().toString();
        String nombre=etNombre.getText().toString();
        String apellido=etApellido.getText().toString();
        int edad=Integer.parseInt(etEdad.getText().toString());
        String key = UUID.randomUUID().toString();
        Alumno a = new Alumno(key,rut,nombre,apellido,edad);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Alumno").child(key);

        myRef.setValue(a);

    }
}
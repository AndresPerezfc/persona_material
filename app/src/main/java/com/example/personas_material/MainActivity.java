package com.example.personas_material;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorPersona.OnPersonaClickListener  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab;
        RecyclerView lstPersonas;
        LinearLayoutManager llm;
        ArrayList<Persona> personas;
        AdaptadorPersona adapter;

        lstPersonas = findViewById(R.id.lstPersona);
        llm = new LinearLayoutManager(this);
        personas = Datos.obtener();
        adapter = new AdaptadorPersona(personas, this);

        llm.setOrientation(RecyclerView.VERTICAL);
        lstPersonas.setLayoutManager(llm);
        lstPersonas.setAdapter(adapter);

        fab = findViewById(R.id.btnAgregar);
    }

    public void agregar(View v){
        Intent i;
        i = new Intent(MainActivity.this, AgregarPersona.class);
        startActivity(i);
        //finish();
    }

    @Override
    public void onPersonaClick(Persona p) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();
        bundle.putString("cedula", p.getCedula());
        bundle.putString("nombre", p.getNombre());
        bundle.putString("apellido", p.getApellido());
        bundle.putInt("foto", p.getFoto());

        intent = new Intent(MainActivity.this, DetallePersona.class);
        intent.putExtra("datos", bundle);
        startActivity(intent);
        finish();
    }
}

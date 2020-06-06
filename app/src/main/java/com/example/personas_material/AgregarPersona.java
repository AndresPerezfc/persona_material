package com.example.personas_material;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.Random;

public class AgregarPersona extends AppCompatActivity {

    private ArrayList<Integer> fotos;
    private EditText nombre, apellido, cedula;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = findViewById(R.id.txtNombre);
        apellido = findViewById(R.id.txtApellido);
        cedula = findViewById(R.id.txtCedula);

        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);

        storageReference = FirebaseStorage.getInstance().getReference();
    }

    public void subir_foto(String id, int foto){
        StorageReference child = storageReference.child(id);
        Uri uri = Uri.parse("android.resource://"+R.class.getPackage().getName()+"/"+foto);
        UploadTask uploadTask = child.putFile(uri);
    }

    public void limpiar(View v){
        limpiar();
    }

    public void guardar(View v){
        String ced, nom, apell, id;
        int foto;
        Persona persona;
        InputMethodManager imp = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        ced = cedula.getText().toString();
        nom = nombre.getText().toString();
        apell = apellido.getText().toString();
        foto = foto_aleatoria();
        id = Datos.getId();
        persona = new Persona(ced, nom, apell, foto, id);
        persona.guardar();
        subir_foto(id, foto);
        limpiar();
        imp.hideSoftInputFromWindow(cedula.getWindowToken(), 0);
        Snackbar.make(v, getString(R.string.mensaje_guardar), Snackbar.LENGTH_LONG).show();
    }

    public int foto_aleatoria(){
        int foto_seleccionada;
        Random r = new Random();
        foto_seleccionada = r.nextInt(this.fotos.size());
        return fotos.get(foto_seleccionada);
    }

    public void limpiar(){
        cedula.setText("");
        nombre.setText("");
        apellido.setText("");
        cedula.requestFocus();
    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(AgregarPersona.this, MainActivity.class);
        startActivity(i);
    }
}

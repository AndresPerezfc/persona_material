package com.example.personas_material;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallePersona extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_persona);

        Bundle bundle;
        Intent intent;

        ImageView foto = findViewById(R.id.imgFotoDetalle);
        TextView  cedula = findViewById(R.id.lblCedulaDetalle);
        TextView nombre = findViewById(R.id.lblNombreDetalle);
        TextView apellido = findViewById(R.id.lblApellidoDetalle);

        intent = getIntent();
        bundle = intent.getBundleExtra("datos");

        foto.setImageResource(bundle.getInt("foto"));
        cedula.setText(bundle.getString("cedula"));
        nombre.setText(bundle.getString("nombre"));
        apellido.setText(bundle.getString("apellido"));
    }

    public void onBackPressed(){
        finish();
        Intent intent = new Intent(DetallePersona.this, MainActivity.class);
        startActivity(intent);
    }
}

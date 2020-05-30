package com.example.personas_material;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.PersonaViewHolder>{

    private ArrayList<Persona> personas;

    public AdaptadorPersona(ArrayList<Persona> personas){
        this.personas = personas;
    }


    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class PersonaViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView cedula;
        private TextView nombre;
        private TextView apellido;
        private View v;

        public PersonaViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            cedula = v.findViewById(R.id.lblcedula);
            nombre = v.findViewById(R.id.lblnombre);
            apellido = v.findViewById(R.id.lblapellido);
        }
    }

    }
}

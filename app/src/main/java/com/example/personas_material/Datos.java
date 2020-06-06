package com.example.personas_material;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Datos {
    private static String db = "Personas";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Persona> personas = new ArrayList<>();

    public static String getId(){
        return databaseReference.push().getKey();
    }

    public static void guardar(Persona p){
        databaseReference.child(db).child(p.getId()).setValue(p);
        //personas.add(p);
    }

    public static void setPersonas(ArrayList<Persona> personas){
        personas = personas;
    }

    public static void eliminar (Persona p){
        for (int i = 0; i < personas.size(); i++){
            if(personas.get(i).getCedula().equals(p.getCedula())){
                personas.remove(i);
                break;
            }

        }
        personas.remove(p);
    }

    public static ArrayList<Persona> obtener(){
        return personas;
    }


}

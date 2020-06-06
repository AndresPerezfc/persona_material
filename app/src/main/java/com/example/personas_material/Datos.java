package com.example.personas_material;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Datos {
    private static String db = "Personas";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Persona> personas = new ArrayList<>();
    private static StorageReference storageReference = FirebaseStorage.getInstance().getReference();

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
        databaseReference.child(db).child(p.getId()).removeValue();
        storageReference.child(p.getId()).delete();
    }

    public static ArrayList<Persona> obtener(){
        return personas;
    }


}

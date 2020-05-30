package com.example.personas_material;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<Persona> personas = new ArrayList<>();

    public static void guardar(Persona p){
        personas.add(p);
    }

    public static ArrayList<Persona> obtener(){
        return personas;
    }
}

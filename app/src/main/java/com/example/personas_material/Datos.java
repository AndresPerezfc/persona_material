package com.example.personas_material;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<Persona> personas = new ArrayList<>();

    public static void guardar(Persona p){
        personas.add(p);
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

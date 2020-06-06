package com.example.personas_material;

public class Persona {

    private String cedula;
    private String nombre;
    private String apellido;
    private int foto;
    private String id;

    public Persona(String cedula, String nombre, String apellido, int foto){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
    }

    public Persona(String cedula, String nombre, String apellido, int foto, String id){
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.foto = foto;
        this.id =id;
    }

    public Persona(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public void guardar(){
        Datos.guardar(this);

    }

    public void eliminar(){
        Datos.eliminar(this);
    }
}

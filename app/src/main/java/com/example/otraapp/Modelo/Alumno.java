package com.example.otraapp.Modelo;

public class Alumno {
    public String key;
    public String rut;
    public String nombre;
    public String apellido;
    public int edad;

    public Alumno() {

    }

    public Alumno(String key, String rut, String nombre, String apellido, int edad) {
        this.key = key;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido= apellido;
        this.edad = edad;
    }
}

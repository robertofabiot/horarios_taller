package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Docente {
    private String cif;
    private String nombre;
    private String apellido;
    private String correo;
    private List<Horario> horariosDisponibles;

    public Docente() {
        this.horariosDisponibles = new ArrayList<>();
    }

    public Docente(String cif, String nombre, String apellido, String correo) {
        this.cif = cif;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.horariosDisponibles = new ArrayList<>();
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Horario> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public void setHorariosDisponibles(List<Horario> horariosDisponibles) {
        this.horariosDisponibles = horariosDisponibles;
    }

    public void agregarHorarioDisponible(Horario horario) {
        this.horariosDisponibles.add(horario);
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " (CIF: " + cif + ")";
    }
}
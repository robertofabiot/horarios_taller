package com.example.models;

public abstract class Curso {
    private String codigo;
    private String nombre;
    private Horario horario;
    private Docente docente;

    public Curso() {}

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public String toString() {
        String docenteAsignado = (docente != null) ? docente.getNombre() + " " + docente.getApellido() : "Sin asignar";
        return "[" + codigo + "] " + nombre + " | Docente: " + docenteAsignado;
    }
}
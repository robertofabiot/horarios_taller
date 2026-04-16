package com.example.models;

public class CursoPractico extends Curso {
    private boolean requiereLaboratorio;
    private int cantidadPracticas;

    public CursoPractico() {
        super();
    }

    public CursoPractico(String codigo, String nombre, boolean requiereLaboratorio, int cantidadPracticas) {
        super(codigo, nombre);
        this.requiereLaboratorio = requiereLaboratorio;
        this.cantidadPracticas = cantidadPracticas;
    }

    public boolean isRequiereLaboratorio() {
        return requiereLaboratorio;
    }

    public void setRequiereLaboratorio(boolean requiereLaboratorio) {
        this.requiereLaboratorio = requiereLaboratorio;
    }

    public int getCantidadPracticas() {
        return cantidadPracticas;
    }

    public void setCantidadPracticas(int cantidadPracticas) {
        this.cantidadPracticas = cantidadPracticas;
    }
}
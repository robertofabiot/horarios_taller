package com.example.models;

public class Horario {
    private int dia; // Ej: 1 para Lunes, 2 para Martes
    private int horaInicio; // Ej: 14 para las 14:00 (2 PM)
    private int duracionHoras;

    public Horario() {}

    public Horario(int dia, int horaInicio, int duracionHoras) {
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.duracionHoras = duracionHoras;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {
        this.duracionHoras = duracionHoras;
    }

    @Override
    public String toString() {
        return "Día: " + dia + " | Hora de inicio: " + horaInicio + "h | Duración: " + duracionHoras + "h";
    }
}
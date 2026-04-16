package com.example.models;

public class CursoTeorico extends Curso {
    private int cantidadExamenes;

    public CursoTeorico() {
        super();
    }

    public CursoTeorico(String codigo, String nombre, int cantidadExamenes) {
        super(codigo, nombre);
        this.cantidadExamenes = cantidadExamenes;
    }

    public int getCantidadExamenes() {
        return cantidadExamenes;
    }

    public void setCantidadExamenes(int cantidadExamenes) {
        this.cantidadExamenes = cantidadExamenes;
    }
}
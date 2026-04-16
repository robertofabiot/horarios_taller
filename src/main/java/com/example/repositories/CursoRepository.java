package com.example.repositories;

import com.example.models.Curso;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository implements ICursoRepository {
    private final List<Curso> cursos;

    public CursoRepository() {
        this.cursos = new ArrayList<>();
    }

    @Override
    public void guardar(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public List<Curso> obtenerTodos() {
        return new ArrayList<>(cursos);
    }

    @Override
    public Curso buscarPorCodigo(String codigo) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }
}
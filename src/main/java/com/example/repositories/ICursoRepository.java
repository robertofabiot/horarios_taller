package com.example.repositories;

import com.example.models.Curso;
import java.util.List;

public interface ICursoRepository {
    void guardar(Curso curso);
    List<Curso> obtenerTodos();
    Curso buscarPorCodigo(String codigo);
}
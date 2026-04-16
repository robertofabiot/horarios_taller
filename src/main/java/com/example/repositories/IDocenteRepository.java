package com.example.repositories;

import com.example.models.Docente;
import java.util.List;

public interface IDocenteRepository {
    void guardar(Docente docente);
    List<Docente> obtenerTodos();
    Docente buscarPorCif(String cif);
}
package com.example.services;

import com.example.models.Curso;
import com.example.models.Docente;
import java.util.List;

public interface IAsignacionService {
    void registrarCurso(Curso curso) throws IllegalArgumentException;
    void registrarDocente(Docente docente) throws IllegalArgumentException;
    void asignarDocenteACurso(String codigoCurso, String cifDocente) throws IllegalArgumentException;
    List<Curso> obtenerTodosLosCursos();
    List<Docente> obtenerTodosLosDocentes();
}
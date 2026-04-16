package com.example.services;

import com.example.models.Curso;
import com.example.models.Docente;
import java.util.List;

public interface IAsignacionService {
    void registrarCurso(Curso curso);
    void registrarDocente(Docente docente);
    boolean asignarDocenteACurso(String codigoCurso, String cifDocente);
    List<Curso> obtenerTodosLosCursos();
    List<Docente> obtenerTodosLosDocentes();
}
package com.example.services;

import com.example.models.Curso;
import com.example.models.Docente;
import com.example.repositories.ICursoRepository;
import com.example.repositories.IDocenteRepository;

import java.util.List;

public class AsignacionService implements IAsignacionService {

    private final ICursoRepository cursoRepository;
    private final IDocenteRepository docenteRepository;

    public AsignacionService(ICursoRepository cursoRepository, IDocenteRepository docenteRepository) {
        this.cursoRepository = cursoRepository;
        this.docenteRepository = docenteRepository;
    }

    @Override
    public void registrarCurso(Curso curso) {
        // Validación: Evitar códigos duplicados
        if (cursoRepository.buscarPorCodigo(curso.getCodigo()) != null) {
            throw new IllegalArgumentException("Error: Ya existe un curso registrado con el código '" + curso.getCodigo() + "'.");
        }
        cursoRepository.guardar(curso);
    }

    @Override
    public void registrarDocente(Docente docente) {
        // Validación: Evitar CIFs duplicados
        if (docenteRepository.buscarPorCif(docente.getCif()) != null) {
            throw new IllegalArgumentException("Error: Ya existe un docente registrado con el CIF '" + docente.getCif() + "'.");
        }
        docenteRepository.guardar(docente);
    }

    @Override
    public void asignarDocenteACurso(String codigoCurso, String cifDocente) {
        Curso curso = cursoRepository.buscarPorCodigo(codigoCurso);
        if (curso == null) {
            throw new IllegalArgumentException("Error: El curso con código '" + codigoCurso + "' no existe.");
        }

        Docente docente = docenteRepository.buscarPorCif(cifDocente);
        if (docente == null) {
            throw new IllegalArgumentException("Error: El docente con CIF '" + cifDocente + "' no existe.");
        }

        // Si ambas validaciones pasan, asignamos
        curso.setDocente(docente);
    }

    @Override
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.obtenerTodos();
    }

    @Override
    public List<Docente> obtenerTodosLosDocentes() {
        return docenteRepository.obtenerTodos();
    }
}
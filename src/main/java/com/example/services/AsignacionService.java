package com.example.services;

import com.example.models.Curso;
import com.example.models.Docente;
import com.example.repositories.ICursoRepository;
import com.example.repositories.IDocenteRepository;

import java.util.List;

public class AsignacionService implements IAsignacionService {

    // Dependemos de las interfaces, no de las implementaciones directas
    private final ICursoRepository cursoRepository;
    private final IDocenteRepository docenteRepository;

    // Inyección de dependencias mediante el constructor
    public AsignacionService(ICursoRepository cursoRepository, IDocenteRepository docenteRepository) {
        this.cursoRepository = cursoRepository;
        this.docenteRepository = docenteRepository;
    }

    @Override
    public void registrarCurso(Curso curso) {
        cursoRepository.guardar(curso);
    }

    @Override
    public void registrarDocente(Docente docente) {
        docenteRepository.guardar(docente);
    }

    @Override
    public boolean asignarDocenteACurso(String codigoCurso, String cifDocente) {
        Curso curso = cursoRepository.buscarPorCodigo(codigoCurso);
        Docente docente = docenteRepository.buscarPorCif(cifDocente);

        // Validamos que ambos existan antes de asignar
        if (curso != null && docente != null) {
            curso.setDocente(docente);
            return true; // Asignación exitosa
        }

        return false; // Falló la asignación (código o CIF incorrectos)
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
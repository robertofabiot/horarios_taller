package com.example.repositories;

import com.example.models.Docente;
import java.util.ArrayList;
import java.util.List;

public class DocenteRepository implements IDocenteRepository {
    private final List<Docente> docentes;

    public DocenteRepository() {
        this.docentes = new ArrayList<>();
    }

    @Override
    public void guardar(Docente docente) {
        docentes.add(docente);
    }

    @Override
    public List<Docente> obtenerTodos() {
        return new ArrayList<>(docentes);
    }

    @Override
    public Docente buscarPorCif(String cif) {
        return docentes.stream()
                .filter(d -> d.getCif().equalsIgnoreCase(cif))
                .findFirst()
                .orElse(null);
    }
}
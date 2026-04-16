package com.example;

import com.example.repositories.CursoRepository;
import com.example.repositories.DocenteRepository;
import com.example.services.AsignacionService;
import com.example.views.ConsolaView;

public class Main {
    public static void main(String[] args) {

        // 1. Instanciamos la capa de datos (Repositorios)
        CursoRepository cursoRepository = new CursoRepository();
        DocenteRepository docenteRepository = new DocenteRepository();

        // 2. Instanciamos la capa lógica (Servicio) inyectando los repositorios
        AsignacionService asignacionService = new AsignacionService(cursoRepository, docenteRepository);

        // 3. Instanciamos la capa de presentación (Vista) inyectando el servicio
        ConsolaView consolaView = new ConsolaView(asignacionService);

        // 4. Arrancamos el programa
        consolaView.iniciar();
    }
}
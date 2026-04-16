package com.example.views;

import com.example.models.CursoPractico;
import com.example.models.CursoTeorico;
import com.example.models.Docente;
import com.example.models.Horario;
import com.example.services.IAsignacionService;
import com.example.utils.ScannerUtil;

public class ConsolaView {

    private final IAsignacionService asignacionService;

    // Inyectamos el servicio
    public ConsolaView(IAsignacionService asignacionService) {
        this.asignacionService = asignacionService;
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = ScannerUtil.leerEntero("Seleccione una opción: ", 1, 6);

            try {
                procesarOpcion(opcion);
            } catch (IllegalArgumentException e) {
                // Atrapamos cualquier error de validación del Service y lo mostramos bonito
                System.out.println("\n" + e.getMessage());
            } catch (Exception e) {
                System.out.println("\nOcurrió un error inesperado: " + e.getMessage());
            }

            System.out.println(); // Salto de línea para separar iteraciones
        } while (opcion != 6);
    }

    private void mostrarMenu() {
        System.out.println("========================================");
        System.out.println("  SISTEMA DE GESTIÓN ACADÉMICA");
        System.out.println("========================================");
        System.out.println("1. Registrar nuevo Curso");
        System.out.println("2. Registrar nuevo Docente");
        System.out.println("3. Asignar Docente a Curso");
        System.out.println("4. Mostrar todos los Cursos");
        System.out.println("5. Mostrar todos los Docentes");
        System.out.println("6. Salir");
        System.out.println("========================================");
    }

    private void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1 -> registrarCurso();
            case 2 -> registrarDocente();
            case 3 -> asignarDocente();
            case 4 -> mostrarCursos();
            case 5 -> mostrarDocentes();
            case 6 -> System.out.println("Bai");
        }
    }

    private void registrarCurso() {
        System.out.println("\n--- REGISTRO DE CURSO ---");
        String codigo = ScannerUtil.leerTexto("Código del curso: ");
        String nombre = ScannerUtil.leerTexto("Nombre del curso: ");

        System.out.println("Horario del curso:");
        int dia = ScannerUtil.leerEntero("  Día (1-Lunes, 2-Martes, etc.): ", 1, 7);
        int horaInicio = ScannerUtil.leerEntero("  Hora de inicio (0-23): ", 0, 23);
        int duracion = ScannerUtil.leerEntero("  Duración en horas: ", 1, 6);
        Horario horario = new Horario(dia, horaInicio, duracion);

        int tipo = ScannerUtil.leerEntero("¿Es un curso Teórico (1) o Práctico (2)?: ", 1, 2);

        if (tipo == 1) {
            int examenes = ScannerUtil.leerEntero("Cantidad de exámenes: ");
            CursoTeorico curso = new CursoTeorico(codigo, nombre, examenes);
            curso.setHorario(horario);
            asignacionService.registrarCurso(curso);
        } else {
            int practicas = ScannerUtil.leerEntero("Cantidad de prácticas: ");
            boolean lab = ScannerUtil.leerEntero("¿Requiere laboratorio? (1-Sí, 0-No): ", 0, 1) == 1;
            CursoPractico curso = new CursoPractico(codigo, nombre, lab, practicas);
            curso.setHorario(horario);
            asignacionService.registrarCurso(curso);
        }
        System.out.println("Curso registrado exitosamente.");
    }

    private void registrarDocente() {
        System.out.println("\n--- REGISTRO DE DOCENTE ---");
        String cif = ScannerUtil.leerTexto("CIF del docente: ");
        String nombre = ScannerUtil.leerTexto("Nombre: ");
        String apellido = ScannerUtil.leerTexto("Apellido: ");
        String correo = ScannerUtil.leerTexto("Correo electrónico: ");

        Docente docente = new Docente(cif, nombre, apellido, correo);
        asignacionService.registrarDocente(docente);
        System.out.println("Docente registrado exitosamente.");
    }

    private void asignarDocente() {
        System.out.println("\n--- ASIGNACIÓN DE DOCENTE A CURSO ---");
        String codigo = ScannerUtil.leerTexto("Ingrese el código del Curso: ");
        String cif = ScannerUtil.leerTexto("Ingrese el CIF del Docente: ");

        asignacionService.asignarDocenteACurso(codigo, cif);
        System.out.println("Docente asignado al curso exitosamente.");
    }

    private void mostrarCursos() {
        System.out.println("\n--- LISTA DE CURSOS ---");
        var cursos = asignacionService.obtenerTodosLosCursos();
        if (cursos.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            cursos.forEach(curso -> System.out.println("- " + curso.toString()));
        }
    }

    private void mostrarDocentes() {
        System.out.println("\n--- LISTA DE DOCENTES ---");
        var docentes = asignacionService.obtenerTodosLosDocentes();
        if (docentes.isEmpty()) {
            System.out.println("No hay docentes registrados.");
        } else {
            docentes.forEach(docente -> System.out.println("- " + docente.toString()));
        }
    }
}
# Sistema de Gestión de Cursos y Docentes

Sistema básico para la gestión y asignación de cursos y docentes en un período académico, desarrollado como parte de una actividad educativa.

---

![Lenguaje](https://img.shields.io/badge/language-Java%20JDK%2021-blue)
![Tipo](https://img.shields.io/badge/type-Proyecto%20Académico-gray)
![Estado](https://img.shields.io/badge/status-Finalizado-success)
![Modelado](https://img.shields.io/badge/modeling-UML-lightgrey)

---

## Descripción

Este proyecto consiste en el análisis, modelado e implementación en consola de un sistema que permite organizar cursos y docentes dentro de un período académico. Se enfoca en representar correctamente los elementos del sistema mediante un enfoque orientado a objetos, aplicando principios SOLID y una arquitectura basada en capas (Models, Repositories, Services, Views).

Este trabajo tiene fines educativos y forma parte del taller de abstracción de clases y objetos.

---

## Contexto Académico

- Asignatura: Programación Orientada a Objetos
- Actividad: Taller – Abstracción de Clases y Objetos
- Objetivo: Aplicar conceptos fundamentales de modelado orientado a objetos mediante la identificación de clases, atributos, métodos y relaciones.

---

## Objetivos del Proyecto

- Analizar un problema propuesto.
- Identificar las entidades principales del sistema.
- Definir clases, atributos y métodos (delegados a servicios).
- Modelar relaciones como herencia, composición, asociación y dependencia.
- Representar la solución mediante un diagrama de clases UML.
- Implementar el diseño en Java utilizando buenas prácticas de programación.

---

## Estructura del Proyecto

```text
/
├── readme.md
├── pom.xml
├── /docs
│   ├── problema.md
│   ├── explicacion.md
│   ├── diagrama-clases.png
│   └── diagrama-clases.drawio
└── /src/main/java/com/example
    ├── Main.java
    ├── /models
    │   ├── Curso.java
    │   ├── CursoPractico.java
    │   ├── CursoTeorico.java
    │   ├── Docente.java
    │   └── Horario.java
    ├── /repositories
    │   ├── ICursoRepository.java
    │   ├── IDocenteRepository.java
    │   ├── CursoRepository.java
    │   └── DocenteRepository.java
    ├── /services
    │   ├── IAsignacionService.java
    │   └── AsignacionService.java
    ├── /utils
    │   └── ScannerUtil.java
    └── /views
        └── ConsolaView.java
```

---

## Documentación

En la carpeta `/docs` se encuentra toda la documentación teórica del taller:

- Definición del problema
- Descripción de clases, atributos y métodos
- Explicación de relaciones entre clases y decisiones de diseño
- Diagrama de clases (PNG y archivo fuente de Draw.io)

---

## Tecnologías Utilizadas

- Java (JDK 21)
- Maven
- UML
- Draw.io

---

## Autor

Roberto Fabio Tercero Membreño
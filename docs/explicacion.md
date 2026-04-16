# Explicación del Modelo Orientado a Objetos

Este documento detalla el análisis y diseño del modelo de clases para el sistema básico de gestión de cursos y docentes, justificando las decisiones tomadas y las relaciones establecidas.

## 1. Clases Identificadas y Atributos

Se optó por un diseño de modelo de dominio puro (modelos anémicos) donde las clases encapsulan los datos y el comportamiento se delegaría a capas de servicio posteriores.

### `Curso` (Clase Base)
Representa la entidad central del sistema, encargada de agrupar la información general de una asignatura ofertada.
* **Atributos:**
    * `- codigo : String`
    * `- nombre : String`
    * `- horario : Horario`
    * `- docente : Docente`

### `CursoTeorico` y `CursoPractico` (Clases Hijas)
Especializaciones de la clase `Curso`.
* **Atributos de `CursoTeorico`:**
    * `- cantidadExamenes : int` (Define la carga de evaluación teórica).
* **Atributos de `CursoPractico`:**
    * `- requiereLaboratorio : bool` (Indica si se necesita infraestructura especial).
    * `- cantidadPracticas : int` (Define la cantidad de sesiones prácticas).

### `Docente`
Representa al profesional encargado de impartir uno o más cursos.
* **Atributos:**
    * `- cif : String`
    * `- nombre : String`
    * `- apellido : String`
    * `- correo : String`
    * `- horariosDisponibles : List<Horario>`

### `Horario`
Encapsula la estructura temporal de las clases, evitando el uso de tipos primitivos (como cadenas de texto) y garantizando una mejor integridad de los datos.
* **Atributos:**
    * `- dia : int`
    * `- horaInicio : int`
    * `- duracionHoras : int`

---

## 2. Relaciones entre Clases

Para modelar correctamente la interacción entre las entidades, se aplicaron los siguientes principios de POO:

* **Herencia (Generalización):** `CursoTeorico` y `CursoPractico` heredan de `Curso`. La herencia se justifica estructuralmente, ya que, aunque comparten la misma base de datos generales (código, nombre, etc.), poseen atributos específicos distintos derivados de su naturaleza académica (ej. uso de laboratorio vs. cantidad de exámenes).
* **Composición:** Existe una relación de composición entre `Curso` y `Horario` (1 a 1). Se determinó que el horario es un elemento estructural del curso; el objeto horario pertenece de forma exclusiva a ese curso y su ciclo de vida depende del mismo.
* **Asociación:** Existe una relación entre `Curso` y `Docente`. Un curso es impartido por un único docente asignado (1), mientras que un docente puede tener una relación con múltiples cursos (`0..n`).
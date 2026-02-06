package Diapositivas.Actividad3;

import java.sql.Date;

public class PruebaActividad3 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("    INICIO DE LA DEMOSTRACIÓN ACTIVIDAD 3");
        System.out.println("=========================================");

        // 1. GESTIÓN DE PROFESORES
        System.out.println("\n--- 1. GESTIÓN DE PROFESORES ---");
        ProfesorDAO profDao = new ProfesorDAO();
        // Insertar
        System.out.println("[INSERT] Insertando profesor (ID 10)...");
        profDao.insertar(10, "Alan", "Turing", "Math", "Criptografía", "555-0001");
        // Listar
        System.out.println("[SELECT] Listando profesores:");
        profDao.listar();
        // Actualizar
        System.out.println("[UPDATE] Actualizando teléfono del profesor 10...");
        profDao.actualizar(10, "Alan", "Turing", "Math", "Criptografía", "666-9999");

        // 2. GESTIÓN DE CURSOS ESCOLARES
        System.out.println("\n--- 2. GESTIÓN DE CURSOS ESCOLARES ---");
        Curso_EscolarDAO cursoDao = new Curso_EscolarDAO();
        // Insertar
        System.out.println("[INSERT] Insertando curso escolar (ID 1)...");
        cursoDao.insertar(1, 2023, 2024);
        // Listar
        System.out.println("[SELECT] Listando cursos:");
        cursoDao.listar();

        // 3. GESTIÓN DE ALUMNOS
        System.out.println("\n--- 3. GESTIÓN DE ALUMNOS ---");
        AlumnoDAO alumnoDao = new AlumnoDAO();
        // Insertar
        System.out.println("[INSERT] Insertando alumno (Matrícula A001)...");
        Date fechaNac = Date.valueOf("2005-01-15"); // Formato YYYY-MM-DD
        alumnoDao.insertar("A001", "Ada", "Lovelace", "Byron", fechaNac, "600-123456");
        // Listar
        System.out.println("[SELECT] Listando alumnos:");
        alumnoDao.listar();

        // 4. GESTIÓN DE ASIGNATURAS (Requiere Profesor)
        System.out.println("\n--- 4. GESTIÓN DE ASIGNATURAS ---");
        AsignaturaDAO asignaturaDao = new AsignaturaDAO();
        // Insertar (Asignamos el profesor ID 10 creado antes)
        System.out.println("[INSERT] Insertando asignatura (COD: PROG) asignada al Prof. 10...");
        asignaturaDao.insertar("PROG", "Programación", 250, 10);
        // Listar
        System.out.println("[SELECT] Listando asignaturas:");
        asignaturaDao.listar();

        // 5. GESTIÓN DE MATRÍCULA (Requiere Alumno, Curso, Asignatura)
        System.out.println("\n--- 5. GESTIÓN DE MATRÍCULAS ---");
        MatriculaDAO matriculaDao = new MatriculaDAO();
        // Insertar
        System.out.println("[INSERT] Matriculando a A001 en PROG para el curso 1...");
        matriculaDao.insertar("A001", 1, "PROG");
        // Listar
        System.out.println("[SELECT] Listando matrículas:");
        matriculaDao.listar();

        // 6. LIMPIEZA (Borrado en orden inverso para respetar FK)
        System.out.println("\n--- 6. LIMPIEZA DE DATOS (DELETE) ---");

        System.out.println("[DELETE] Borrando matrícula...");
        matriculaDao.borrar("A001", 1, "PROG");

        System.out.println("[DELETE] Borrando asignatura PROG...");
        asignaturaDao.borrar("PROG");

        System.out.println("[DELETE] Borrando alumno A001...");
        alumnoDao.borrar("A001");

        System.out.println("[DELETE] Borrando curso 1...");
        cursoDao.borrar(1);

        System.out.println("[DELETE] Borrando profesor 10...");
        profDao.borrar(10);

        System.out.println("\n=========================================");
        System.out.println("       FIN DE LA DEMOSTRACIÓN");
        System.out.println("=========================================");
    }
}

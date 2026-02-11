package Diapositivas.Actividad6.modelo;

public class Matricula {
    private String refAlumno;
    private int idCurso;
    private String codAsignatura;

    public Matricula(String refAlumno, int idCurso, String codAsignatura) {
        this.refAlumno = refAlumno;
        this.idCurso = idCurso;
        this.codAsignatura = codAsignatura;
    }

    public String getRefAlumno() {
        return refAlumno;
    }

    public void setRefAlumno(String refAlumno) {
        this.refAlumno = refAlumno;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(String codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: [Alumno: %s] [Curso: %d] [Asignatura: %s]", refAlumno, idCurso, codAsignatura);
    }
}

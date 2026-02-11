package Diapositivas.Actividad6.modelo;

import java.sql.Date;

public class Alumno {
    private String numeroMatricula;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private String telefono;

    public Alumno(String numeroMatricula, String nombre, String apellido1, String apellido2, Date fechaNacimiento,
            String telefono) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %s | %s %s %s | Nac: %s | Tlf: %s", numeroMatricula, nombre, apellido1,
                apellido2, fechaNacimiento, telefono);
    }
}

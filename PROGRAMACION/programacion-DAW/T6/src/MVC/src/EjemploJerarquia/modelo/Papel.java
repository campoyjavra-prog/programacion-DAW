package MVC.src.EjemploJerarquia.modelo;

import java.sql.Date;

public class Papel extends Libro {
    private Date fechaImpresion;
    private String lugarImpresion;

    public Papel(int id, String isbn, String titulo, String descripcion, int anioPublicacion, double precio,
            Date fechaImpresion, String lugarImpresion) {
        super(id, isbn, titulo, descripcion, anioPublicacion, precio);
        this.fechaImpresion = fechaImpresion;
        this.lugarImpresion = lugarImpresion;
    }

    public Date getFechaImpresion() {
        return fechaImpresion;
    }

    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }

    public String getLugarImpresion() {
        return lugarImpresion;
    }

    public void setLugarImpresion(String lugarImpresion) {
        this.lugarImpresion = lugarImpresion;
    }

    @Override
    public String toString() {
        return super.toString() + " | [Papel] Impreso: " + fechaImpresion + " en " + lugarImpresion;
    }
}

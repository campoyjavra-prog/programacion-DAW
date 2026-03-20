package modelo;

import java.sql.Date;

public class Suministro {

    private int codProveedor;
    private int codPieza;
    private int cantidad;
    private Date fecha;

    public Suministro(int codProveedor, int codPieza, int cantidad, Date fecha) {
        this.codProveedor = codProveedor;
        this.codPieza = codPieza;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getCodProveedor() {
        return codProveedor;
    }

    public int getCodPieza() {
        return codPieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }
}
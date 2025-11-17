package clases;

public class ProveedorSuministraPieza {
    Pieza pieza;
    Proveedor proveedor;
    int cantidad;
    String fecha;

    public ProveedorSuministraPieza(){}

    public ProveedorSuministraPieza(Pieza pieza, Proveedor proveedor,int cantidad, String fecha) {
        this.pieza=pieza;
        this.proveedor=proveedor;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public Pieza getPieza() {
        return pieza;
    }

    public void setPieza(Pieza pieza) {
        this.pieza = pieza;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        if (pieza!=null && proveedor !=null)
            return "ProveedorSuministraPieza [pieza=" + pieza.toString() + ", proveedor=" + proveedor.toString() + ", cantidad=" + cantidad
                + ", fecha=" + fecha + "]";
        else return "No hay datos fiables";
    }
    
    
    
}
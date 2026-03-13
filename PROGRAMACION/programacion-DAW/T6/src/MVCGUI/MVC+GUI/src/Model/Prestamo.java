package Model;

public class Prestamo {
    private int idPrestamo;
    private int codigoLibro;
    private String dniUsuario;

    public Prestamo(int idPrestamo, int codigoLibro, String dniUsuario) {
        this.idPrestamo = idPrestamo;
        this.codigoLibro = codigoLibro;
        this.dniUsuario = dniUsuario;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public int getCodigoLibro() {
        return codigoLibro;
    }

    public void setCodigoLibro(int codigoLibro) {
        this.codigoLibro = codigoLibro;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }
}

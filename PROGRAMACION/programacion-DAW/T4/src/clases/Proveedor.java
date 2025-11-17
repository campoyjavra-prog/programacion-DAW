package clases;

public class Proveedor {
    int codigo;
    String direccion;
    String ciudad;
    String provincia;
    
    public Proveedor(){}
    public Proveedor(int codigo, String direccion, String ciudad, String provincia) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    @Override
    public String toString() {
        return "Proveedor [codigo=" + codigo + ", direccion=" + direccion + ", ciudad=" + ciudad + ", provincia="
                + provincia + "]";
    }

    
    
}
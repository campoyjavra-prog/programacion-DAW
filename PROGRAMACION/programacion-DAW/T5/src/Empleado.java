class Empleado extends PersonaPadre {
    private String puesto;
    private int salario;

    Empleado(String nombre, int edad, double altura, String puesto, int salario) {
        super(nombre, edad, altura);
        this.puesto = puesto;
        this.salario = salario;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    @Override
    public void imprimeDatos() {
        super.imprimeDatos();
        System.out.println(this.nombre);
        System.out.println(this.salario);
    }

}

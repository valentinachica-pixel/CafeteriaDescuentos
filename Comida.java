package cafeteria.modelo;

/** Una comida de la cafetería. Hereda de Producto. */
public class Comida extends Producto {

    private final boolean vegetariana;

    public Comida(String nombre, double precio, boolean vegetariana) {
        super(nombre, precio);
        this.vegetariana = vegetariana;
    }

    public boolean isVegetariana() {
        return vegetariana;
    }

    @Override
    public String getTipo() {
        return "Comida";
    }

    @Override
    public String describir() {
        String extra = vegetariana ? " - vegetariana" : "";
        return super.describir() + extra;
    }
}

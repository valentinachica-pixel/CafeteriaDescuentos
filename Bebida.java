package cafeteria.modelo;

/** Una bebida de la cafetería. Hereda de Producto. */
public class Bebida extends Producto {

    private final boolean caliente;

    public Bebida(String nombre, double precio, boolean caliente) {
        super(nombre, precio);
        this.caliente = caliente;
    }

    public boolean isCaliente() {
        return caliente;
    }

    @Override
    public String getTipo() {
        return "Bebida";
    }

    @Override
    public String describir() {
        String temperatura = caliente ? "caliente" : "fría";
        return super.describir() + " - " + temperatura;
    }
}

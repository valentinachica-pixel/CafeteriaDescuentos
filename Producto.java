package cafeteria.modelo;

/**
 * Clase base de todo lo que vende la cafetería.
 * Es abstracta porque no se vende un "producto" a secas,
 * siempre es una bebida o una comida.
 */
public abstract class Producto {

    private final String nombre;
    private final double precio;

    protected Producto(String nombre, double precio) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El producto debe tener nombre");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    /** Cada tipo de producto dice qué es. */
    public abstract String getTipo();

    /** Texto para mostrar en pantalla. Las clases hijas lo cambian. */
    public String describir() {
        return String.format("%s - %s ($%.2f)", getTipo(), nombre, precio);
    }
}

package cafeteria.descuento;

/**
 * Calcula el total a pagar usando una regla de descuento.
 * No sabe cuál regla es: la recibe en el constructor.
 * Así se puede cambiar la regla sin tocar esta clase.
 */
public class CalculadoraDescuento {

    private final ReglaDescuento regla;

    public CalculadoraDescuento(ReglaDescuento regla) {
        this.regla = regla;
    }

    public double calcularDescuento(double total) {
        if (total < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        return regla.calcularDescuento(total);
    }

    public double calcularTotalFinal(double total) {
        return total - calcularDescuento(total);
    }
}

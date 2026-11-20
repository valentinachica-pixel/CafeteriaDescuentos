package cafeteria.descuento;

/**
 * Interfaz funcional: tiene un solo método abstracto.
 * Por eso cada regla de descuento se puede escribir como una lambda.
 * Recibe el total del pedido y devuelve cuánto se descuenta.
 */
@FunctionalInterface
public interface ReglaDescuento {

    double calcularDescuento(double total);
}

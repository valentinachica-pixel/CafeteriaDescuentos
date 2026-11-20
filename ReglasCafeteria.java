package cafeteria.descuento;

/**
 * Aquí están las reglas de descuento de la cafetería escritas como lambdas.
 * Para crear una regla nueva se agrega otra lambda aquí,
 * sin cambiar la calculadora ni la ventana.
 */
public final class ReglasCafeteria {

    public static final double MONTO_MINIMO = 10.0;
    public static final double PORCENTAJE = 0.15;

    /** Si el total es mayor a $10 se descuenta el 15 %. Si no, el descuento es 0. */
    public static final ReglaDescuento QUINCE_POR_CIENTO_SOBRE_10 =
            total -> total > MONTO_MINIMO ? total * PORCENTAJE : 0.0;

    /** Regla que no descuenta nada. Sirve para comparar. */
    public static final ReglaDescuento SIN_DESCUENTO = total -> 0.0;

    private ReglasCafeteria() {
        // No se crean objetos de esta clase
    }
}

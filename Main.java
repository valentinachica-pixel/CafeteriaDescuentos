package cafeteria;

import cafeteria.datos.ConexionBD;
import cafeteria.datos.RepositorioProductos;
import cafeteria.descuento.CalculadoraDescuento;
import cafeteria.descuento.ReglasCafeteria;
import cafeteria.vista.VentanaDescuento;

import javax.swing.SwingUtilities;

/** Punto de entrada. Aquí se crean los objetos y se conectan entre sí. */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraDescuento calculadora =
                    new CalculadoraDescuento(ReglasCafeteria.QUINCE_POR_CIENTO_SOBRE_10);
            ConexionBD conexionBD = new ConexionBD();
            RepositorioProductos repositorio = new RepositorioProductos(conexionBD);

            VentanaDescuento ventana =
                    new VentanaDescuento(calculadora, conexionBD, repositorio);
            ventana.setVisible(true);
        });
    }
}

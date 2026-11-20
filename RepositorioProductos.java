package cafeteria.datos;

import cafeteria.modelo.Bebida;
import cafeteria.modelo.Comida;
import cafeteria.modelo.Producto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Guarda y consulta los productos en la base de datos.
 * Usa try-with-resources para que la conexión se cierre sola.
 */
public class RepositorioProductos {

    private final ConexionBD conexionBD;

    public RepositorioProductos(ConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /** Crea la tabla y unos productos de ejemplo si todavía no existen. */
    public void prepararTabla() throws SQLException {
        try (Connection con = conexionBD.abrir();
             Statement st = con.createStatement()) {

            st.executeUpdate("CREATE TABLE IF NOT EXISTS producto ("
                    + "nombre TEXT NOT NULL, "
                    + "precio REAL NOT NULL, "
                    + "tipo TEXT NOT NULL, "
                    + "caracteristica INTEGER NOT NULL)");

            try (ResultSet rs = st.executeQuery("SELECT COUNT(*) FROM producto")) {
                if (rs.next() && rs.getInt(1) == 0) {
                    st.executeUpdate("INSERT INTO producto VALUES "
                            + "('Café americano', 2.50, 'BEBIDA', 1), "
                            + "('Limonada', 3.00, 'BEBIDA', 0), "
                            + "('Sándwich de pollo', 6.50, 'COMIDA', 0), "
                            + "('Empanada de verduras', 2.00, 'COMIDA', 1)");
                }
            }
        }
    }

    /** Consulta todos los productos y los convierte en objetos Bebida o Comida. */
    public List<Producto> listarProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        try (Connection con = conexionBD.abrir();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(
                     "SELECT nombre, precio, tipo, caracteristica FROM producto")) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                boolean caracteristica = rs.getInt("caracteristica") == 1;
                if ("BEBIDA".equals(rs.getString("tipo"))) {
                    productos.add(new Bebida(nombre, precio, caracteristica));
                } else {
                    productos.add(new Comida(nombre, precio, caracteristica));
                }
            }
        }
        return productos;
    }
}

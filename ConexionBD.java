package cafeteria.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Se encarga solo de abrir la conexión con la base de datos SQLite. */
public class ConexionBD {

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String URL = "jdbc:sqlite:cafeteria.db";

    /** Revisa que el driver de SQLite esté en el proyecto. */
    public void cargarDriver() throws ClassNotFoundException {
        Class.forName(DRIVER);
    }

    /** Abre una conexión nueva. Quien la use debe cerrarla. */
    public Connection abrir() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}

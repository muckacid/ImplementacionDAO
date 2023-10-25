package cl.mucka.impl.dao.c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private Statement sen;
    private final Connection con;
    private static Conexion conexion = null;

    public static Conexion getConnection(String bd){
        if (null == conexion) {
            try {
                conexion = new Conexion(bd);
            } catch (SQLException ex) {
                System.err.println("ERROR: No se pudo intanciar la conexion");
            }
        }
        return null;
    }

    private Conexion(String bd) throws SQLException {
        String url = "jdbc:mysql://localhost/" + bd + "?user=root&password=";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
        }
        con = DriverManager.getConnection(url);
    }

    public ResultSet ejecutar(String query) throws SQLException {
        System.out.println(query);
        sen = con.createStatement();

        if (query.toLowerCase().startsWith("insert")
                || query.toLowerCase().startsWith("update")
                || query.toLowerCase().startsWith("delete")) {
            sen.executeUpdate(query);
            close();
            return null;
        }

        return sen.executeQuery(query);
    }

    public void close() throws SQLException {
        sen.close();
    }

}

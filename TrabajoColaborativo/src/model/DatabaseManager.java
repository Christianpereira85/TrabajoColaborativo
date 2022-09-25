package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class DatabaseManager {

    private static Connection oracleConnection;

    private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String USUARIO = "MINIPRO1";
    private static String CONTRA = "MINIPRO1";

    static {
        oracleConnection = null;
        Locale.setDefault(new Locale("es", "ES"));
        
        try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Iniciando Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

        try {

            oracleConnection = DriverManager.getConnection(
                    CONNECTION_STRING,
                    USUARIO,
                    CONTRA);

            System.out.println("conexion creada con exito, es posible acceder a la base de datos");

        } catch (SQLException e) {
            System.out.println("Error al conectarse a la Base de datos");
            System.out.println(e.getErrorCode());
        }
    }

    public static Connection getConnection() {
        return oracleConnection;
    }
}
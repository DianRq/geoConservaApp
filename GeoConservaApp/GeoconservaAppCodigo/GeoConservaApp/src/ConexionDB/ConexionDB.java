package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 *cREACIÓN DE LA CONECCIÓN A LA BASE DE DATOS
 */
public class ConexionDB {

    Connection con;

    public ConexionDB() {
        try {
            //en donde esta el driver que voy a utilizar
            Class.forName("com.mysql.jdbc.Driver");
            //variable de conexion, Establecemos la conexión
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/geoconserva", "root", "");

        } catch (Exception e) {
            //Si algo sale mal, avisame (Mensaje de error 
            //si no se cargo la base, o no existe la base etc etc.
            System.err.println("Error:" + e);

        }

    }
    //Método que retornará una  conexión

    public Connection getConnection() {
        return con;
    }
}

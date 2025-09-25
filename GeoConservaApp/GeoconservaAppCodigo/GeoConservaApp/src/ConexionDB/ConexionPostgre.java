package ConexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import org.postgresql.util.PGobject;
/**http://www.java2s.com/Code/Jar/p/Downloadpostgisjar.htm#google_vignette
 * Para la descarga del archivo jar de postgis que si jaló :P
 */


public class ConexionPostgre {

    Connection conPos;

    public ConexionPostgre() {

        try {
            //en donde esta el driver que voy a utilizar
            Class.forName("org.postgresql.Driver");
            //variable de conexion, Establecemos la conexión
            conPos = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Geoconserva", "postgres", "3lls5y-2");
            /**
             * Hacemos un casteo para que decirle que la conexión en conPos si es una conexión de PostgreSQL y 
             * como addDataType no existe en la interfáz Conexión pero si en org.postresql.PGConnection. 
             * le pedimos que trate nuestra coneción como un como un PGConnection. de sql
             * Para la segunda parte en Class EXTENDS aseguramos que la clase que estamos cargando de pggeometry si se extiende de PGobject
             * lo cual es lo que espera nuestro addData https://postgis.net/docs/manual-1.5/ch05.html#id366626
             */
            ((org.postgresql.PGConnection) conPos).addDataType("geometry", (Class<? extends PGobject>) Class.forName("org.postgis.PGgeometry"));
            if (conPos != null) {
                System.out.println("Conexión a Postgres Exitosa!");
            } else {
                System.out.println("Fallo en la conexón");
            }
        } catch (Exception e) {
            //Si algo sale mal, avisame (Mensaje de error 
            //si no se cargo la base, o no existe la base etc etc.
            System.err.println("Error:" + e);

        }

    }
    //Método que retornará una  conexión

    public Connection getConnection() {
        return conPos;
    }
}

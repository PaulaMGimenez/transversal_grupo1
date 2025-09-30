package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;




/**
 * @author Santy
 */
public class conexion {
   //CARGAR DRIVER DE CONEXION
    
    private String URL;
    private String usuario;
    private String password;
    
    private static Connection conexion =  null;

    public conexion(String URL, String usuario, String password) {
        this.URL = URL;
        this.usuario = usuario;
        this.password = password;
    }
    
    public Connection buscarConexion(){
    if(conexion == null){
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/construirsa_tp9", "root", "");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No se puede conectar o cargar driver" + ex.getMessage());
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "No se puede conectar" + e.getMessage());
        }
    
    }
    return conexion;
    }

}


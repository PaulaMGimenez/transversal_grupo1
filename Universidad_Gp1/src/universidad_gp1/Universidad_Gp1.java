/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad_gp1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.JOptionPane;

/**
 *
 * @author paula
 */
public class Universidad_Gp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //CARGAR DRIVER DE CONEXION
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            
            
            //conexion con base de datos
            Connection conn= DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidad_grupo1","root","");
        
        String sql= "insert into alumno(idAlumno, dni, apellido, nombre,fechaNacimiento,estado) values (1, 12345, 'gimenez','paula','"+LocalDate.of(2000,Month.AUGUST,29)+"',1)";
        PreparedStatement ps = conn.prepareStatement(sql);
        int filas= ps.executeUpdate();
        if(filas>0){
            JOptionPane.showMessageDialog(null, "Alumno agregada exitosamente");
        }
        
        
        }catch(ClassNotFoundException ex){
        JOptionPane.showMessageDialog(null, "Debe agregarle los driver al proyecto");
    
        }catch(SQLException ex){
        JOptionPane.showMessageDialog(null, "Error de conexion");
    }
    }
    
}

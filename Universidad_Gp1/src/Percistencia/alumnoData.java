/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import Modelo.alumno;
import Modelo.myConexion;
import com.mysql.jdbc.Statement;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class alumnoData {

    private Connection conn = null;

    public alumnoData(myConexion conexion) {
        this.conn = conexion.buscarConexion();
    }

    public void guardarAlumno(alumno a) throws SQLException {
        String query = "INSERT INTO alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, estado) VALUES(?,?,?,?,?,?)";

        try {
            try (PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, a.getIdAlumno());
                ps.setInt(2, a.getDni());
                ps.setString(3, a.getApellido());
                ps.setString(4, a.getNombre());
                ps.setDate(5, (Date) a.getFechaNacimiento());
                ps.setInt(6, a.getEstado());
                ps.executeUpdate();
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    a.setIdAlumno(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Alumno Guardado Exitosamente");
                } else {
                    System.out.println("No se pudo obtener ID");
                }
            }
            System.out.println("Guardado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabala alumno");
        }
    }
}

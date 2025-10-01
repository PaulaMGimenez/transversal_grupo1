/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Percistencia;

import Modelo.alumno;
import Modelo.myConexion;
import java.sql.Statement;

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

    private final Connection conn;

    public alumnoData() {
        conn = myConexion.buscarConexion();
    }

    public void guardarAlumno(alumno a){
        String query = "INSERT INTO alumno(idAlumno, dni, apellido, nombre, fechaNacimiento, estado)"
                + " VALUES(?,?,?,?,?,?)";

        try {
             PreparedStatement ps = conn.prepareStatement(query,Statement.RETURN_GENERATED_KEYS); 
                ps.setInt(1, a.getIdAlumno());
                ps.setInt(2, a.getDni());
                ps.setString(3, a.getApellido());
                ps.setString(4, a.getNombre());
                ps.setDate(5,  Date.valueOf(a.getFechaNacimiento()));
                ps.setInt(6, a.getEstado());
                
                ps.executeUpdate();
                
                ResultSet rs = ps.getGeneratedKeys();
                
                if (rs.next()) {
                    a.setIdAlumno(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Alumno Guardado Exitosamente");
                } else {
                    System.out.println("No se pudo obtener ID");
                }
                ps.close();
            System.out.println("Guardado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
    }
}

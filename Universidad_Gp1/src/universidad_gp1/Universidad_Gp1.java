/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad_gp1;

import Modelo.alumno;
import Modelo.myConexion;
import Percistencia.alumnoData;
import java.time.LocalDate;

/**
 *
 * @author paula
 */
public class Universidad_Gp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //objeto tipo myConexion
     
    alumno brayan = new alumno(2, 42278291, "Arce", "Brayan", LocalDate.of(1999, 12, 16), 1);
    
    alumnoData alu = new alumnoData();
    
    alu.guardarAlumno(brayan);
    
    }
    
}

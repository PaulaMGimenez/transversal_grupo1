/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad_gp1;

import Modelo.conexion;

/**
 *
 * @author paula
 */
public class Universidad_Gp1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     //objeto tipo conexion
     
    conexion conn = new conexion("jdbc:mysql://localhost/universidad_grupo1", "root", "");
    
    }
    
}

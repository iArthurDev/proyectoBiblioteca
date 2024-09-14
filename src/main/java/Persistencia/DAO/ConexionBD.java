/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ldoar
 */
public class ConexionBD{
    //Instancia unica de la conexión
    private static ConexionBD instanciaUnica;
    private Connection conexion;
    
    //Declaración de constantes para la conexión a la base de datos
    
 
    private ConexionBD(){
//        try {
//            conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    public static ConexionBD getInstance(){
        if (instanciaUnica == null) {
            synchronized (ConexionBD.class) {
                if (instanciaUnica == null) {
                    instanciaUnica = new ConexionBD();
                }
            }
        }
        return instanciaUnica;
    }
    
    public Connection obtenerConexion(){
        return conexion;
    }
    
    public void cerrarConexion(){
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

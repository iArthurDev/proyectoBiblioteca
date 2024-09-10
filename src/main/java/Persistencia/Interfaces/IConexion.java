/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import java.sql.*;

/**
 *
 * @author ldoar
 */
public interface IConexion {
    
    public Connection crearConexion() throws SQLException;
    public Connection obtenerConexion() throws SQLException;
   
}

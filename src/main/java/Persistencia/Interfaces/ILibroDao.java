/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.Libro;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ldoar
 */
public interface ILibroDao {
    
    public List<Libro> selectAll() throws SQLException;
    
    public List<Libro> selectByID(Libro libro) throws SQLException;
    
    public List<Libro> selectByName(Libro libro) throws SQLException;
    
    public int insert(Libro libro) throws SQLException;
    
    public int update(Libro libro) throws SQLException;
    
    public int delete(Libro libro) throws SQLException;
}

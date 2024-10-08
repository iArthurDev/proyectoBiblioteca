/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.Libro;
import java.util.List;

/**
 *
 * @author ldoar
 */
public interface ILibroDao {
    
    public List<Libro> selectAll();
    
    public Libro selectByID(Libro libro);
    
    public List<Libro> selectByName(String titulo);
    
    public int insert(Libro libro);
    
    public int update(Libro libro);
    
    public int delete(Libro libro);
}

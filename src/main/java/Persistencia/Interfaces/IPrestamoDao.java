/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.Libro;
import Dominio.Prestamo;
import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author ldoar
 */
public interface IPrestamoDao {

    public List<Prestamo> selectAll();

    public List<Prestamo> selectByUsuario(String usuario);
    
    public void insert(Usuario idUsuario, List<Libro> listaLibros);
    
    public void updateDevolucion(Prestamo idPrestamo, List<Libro> listaLibros);
    
    public void updateFechaEntrega(Prestamo prestamo);

}

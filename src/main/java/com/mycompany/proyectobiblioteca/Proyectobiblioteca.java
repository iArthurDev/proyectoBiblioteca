/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectobiblioteca;

import Dominio.Libro;
import Persistencia.DAO.LibroDao;
import java.util.List;

/**
 *
 * @author ldoar
 */
public class Proyectobiblioteca {

    public static void main(String[] args) {
        LibroDao librodao = new LibroDao();
        
        List<Libro> libros = librodao.selectAll();
        
        for (Libro libro : libros) {
            System.out.println("Libro: "+ libro);
        }
    }
}

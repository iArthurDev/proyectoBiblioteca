/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectobiblioteca;

import Dominio.Libro;
import Dominio.Prestamo;
import Dominio.Usuario;
import Persistencia.DAO.LibroDao;
import Persistencia.DAO.PrestamoDao;
import Persistencia.DAO.UsuarioDao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ldoar
 */
public class Proyectobiblioteca {

    public static void main(String[] args) {
        LibroDao librodao = new LibroDao();

        //SELECT de todos los registros de la tabla libro
//        List<Libro> libros = librodao.selectAll();
//        for (Libro libro : libros) {
//            System.out.println("Libro: "+ libro);
//        }
        //SELECT por nombre
//        List<Libro> librosPorCadena = librodao.selectByName("anillo");
//        for (Libro libro : librosPorCadena) {
//            System.out.println("Libro: "+ libro);
//        }
        //INSERT de un nuevo registro
//        Libro nuevoLibro = new Libro("Harry Potter y la piedra filosofal", "J.K.Rowling", "Salamandra ABC", "Fantasia", "1997", 7);
//        librodao.insert(nuevoLibro);

//        LocalDate fechaRegistro = LocalDate.now();
//        java.sql.Date sqlDate = java.sql.Date.valueOf(fechaRegistro);
//        UsuarioDao usuarioDao = new UsuarioDao();
        
        //SELECT de todos los registros de la tabla usuario
//        List<Usuario> usuarios = usuarioDao.selectAll();
//        for (Usuario usuario : usuarios) {
//            System.out.println("Libro: " + usuario);
//        }

        //SELECT por nombre
//        List<Usuario> usuariosPorNombre = usuarioDao.selectByName("j");
//        for (Usuario usuario : usuariosPorNombre) {
//            System.out.println("Libro: "+ usuario);
//        }
        //INSERT de un nuevo registro
//        Usuario usuarioNuevo = new Usuario("Francisco", "Leiva", "pacoLei19@gmail.com", "6442158890", sqlDate);
//        usuarioDao.insert(usuarioNuevo);


        PrestamoDao prestamoDao = new PrestamoDao();
        List<Libro> librosPrestamo = new ArrayList<>();
        
        librosPrestamo.add(librodao.selectByName("Señor de los anillos: Las dos torres").get(0));
        librosPrestamo.add(librodao.selectByName("Harry Potter y la piedra filosofal").get(0));
        
//        for (Libro libro : librosPrestamo) {
//            System.out.println("Libros a prestamo: "+libro);
//        }
        
//        prestamoDao.insert(new Usuario(1), librosPrestamo);

        List<Libro> librosDevolusiones = new ArrayList<>();
        
        librosDevolusiones.add(librosPrestamo.get(0));
        
        System.out.println(librosDevolusiones.get(0));
        
        prestamoDao.updateDevolucion(new Prestamo(19), librosDevolusiones);

//        prestamoDao.updateFechaEntrega(new Prestamo(19));
    }
}

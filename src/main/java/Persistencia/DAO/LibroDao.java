/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Dominio.Libro;
import Persistencia.Interfaces.ILibroDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ldoar
 */
public class LibroDao implements ILibroDao {

    private Connection conexion;

    public LibroDao() {
        this.conexion = ConexionBD.getInstance().obtenerConexion();
    }

    @Override
    public List<Libro> selectAll(){
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (PreparedStatement stmt = conexion.prepareStatement(sql); 
                 ResultSet rs = stmt.executeQuery()) {
            
            while ( rs.next() ) {                
                Libro libro = new Libro(rs.getInt("idLibro"),
                        rs.getString("titulo"),
                        rs.getString("autor"),
                        rs.getString("editorial"),
                        rs.getString("genero"),
                        rs.getString("anioPublicacion"),
                        rs.getInt("copiasDisponibles"));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return libros;
    }

    @Override
    public List<Libro> selectByID(Libro libro){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Libro> selectByName(Libro libro){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(Libro libro){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Libro libro){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Libro libro){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

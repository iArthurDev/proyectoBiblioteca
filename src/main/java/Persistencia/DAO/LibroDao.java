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
import javax.swing.JOptionPane;

/**
 *
 * @author ldoar
 */
public class LibroDao implements ILibroDao {

    private Connection conexion;

    public LibroDao() {
        this.conexion = ConexionBD.getInstance().obtenerConexion();
    }

    /**
     * Metodo que regresa todos los registros de la tabla libro
     *
     * @return
     */
    @Override
    public List<Libro> selectAll() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro";

        try (PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
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
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Advertencia: No se encontraron registros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        return libros;
    }

    @Override
    public Libro selectByID(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Metodo que regresa todos los registros que tengan coindicendia con el
     * String enviado por parámetro
     *
     * @param titulo
     * @return
     */
    @Override
    public List<Libro> selectByName(String titulo) {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libro WHERE titulo LIKE ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {

            if (titulo == null || titulo.trim().isEmpty()) {
                stmt.setString(1, "%");
            } else {
                stmt.setString(1, "%" + titulo + "%");
            }

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Libro libro = new Libro(rs.getInt("idLibro"),
                            rs.getString("titulo"),
                            rs.getString("autor"),
                            rs.getString("editorial"),
                            rs.getString("genero"),
                            rs.getString("anioPublicacion"),
                            rs.getInt("copiasDisponibles"));
                    libros.add(libro);
                }

            } catch (SQLDataException e) {
                e.printStackTrace(System.out);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Advertencia: No se encontraron registros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        return libros;
    }

    /**
     * Metodo que realiza la inserción de un nuevo registro
     * @param libro
     * @return 
     */
    @Override
    public int insert(Libro libro) {
        String sql = "INSERT INTO libro (titulo, autor, editorial, genero, anioPublicacion, copiasDisponibles) "
                + "VALUES (?,?,?,?,?,?)";
        int registros = 0;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, libro.getTitulo());
            stmt.setString(2, libro.getAutor());
            stmt.setString(3, libro.getEditorial());
            stmt.setString(4, libro.getGenero());
            stmt.setString(5, libro.getAnioPublicacion());
            stmt.setInt(6, libro.getCopiasDisponibles());

            registros = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Información: Se guardo el registro correctamente", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        if (registros == 0) {
            JOptionPane.showMessageDialog(null, "Advertencia: No se pudo guardar el registro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        return registros;
    }

    @Override
    public int update(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Libro libro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

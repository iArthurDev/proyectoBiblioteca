/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Dominio.Usuario;
import Persistencia.Interfaces.IUsuarioDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ldoar
 */
public class UsuarioDao implements IUsuarioDao {

    private Connection conexion;

    public UsuarioDao() {
        this.conexion = ConexionBD.getInstance().obtenerConexion();
    }

    /**
     * Me
     * @return 
     */
    @Override
    public List<Usuario> selectAll() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDate("fechaRegistro"));
                
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Advertencia: No se encontraron registros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        return usuarios;
    }

    @Override
    public Usuario selectByID(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> selectByName(String nombre) {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nombre LIKE ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {

            if (nombre == null || nombre.trim().isEmpty()) {
                stmt.setString(1, "%");
            } else {
                stmt.setString(1, "%" + nombre + "%");
            }

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Usuario usuario = new Usuario(rs.getInt("idUsuario"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getDate("fechaRegistro"));
                
                    usuarios.add(usuario);
                }

            } catch (SQLDataException e) {
                e.printStackTrace(System.out);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        if (usuarios.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Advertencia: No se encontraron registros", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
        }
        return usuarios;
    }

    @Override
    public int insert(Usuario usuario) {
        String sql = "INSERT INTO usuario (nombre, apellido, email, telefono, fechaRegistro) "
                + "VALUES (?,?,?,?,?)";
        int registros = 0;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getApellido());
            stmt.setString(3, usuario.getEmail());
            stmt.setString(4, usuario.getTelefono());
            stmt.setDate(5, (Date) usuario.getFechaRegistro());

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
    public int update(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

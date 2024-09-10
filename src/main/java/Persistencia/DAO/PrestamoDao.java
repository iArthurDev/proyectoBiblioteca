/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia.DAO;

import Dominio.Libro;
import Dominio.Prestamo;
import Dominio.Usuario;
import Persistencia.Interfaces.IPrestamoDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ldoar
 */
public class PrestamoDao implements IPrestamoDao {

    private Connection conexion;

    public PrestamoDao() {
        this.conexion = ConexionBD.getInstance().obtenerConexion();
    }

    @Override
    public List<Prestamo> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Prestamo> selectByUsuario(String usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Usuario usuario, List<Libro> listaLibros) {

        try {
            //Inicia transacción
            //Deshabilitar autocomit
            conexion.setAutoCommit(false);

            // Calcular la fecha de entrega
            int diasPrestamo = listaLibros.size() == 1 ? 7 : (listaLibros.size() > 3 ? 15 : 10);
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, diasPrestamo);
            Date fechaEntrega = new Date(calendar.getTimeInMillis());

            String sqlPrestamo = "INSERT INTO prestamo(fechaPrestamo, fechaEntrega, estado, aumentoFecha, numeroLibros, idUsuario) "
                    + "VALUES (?,?,?,?,?,?)";

            try (PreparedStatement stmt = conexion.prepareStatement(sqlPrestamo, PreparedStatement.RETURN_GENERATED_KEYS)) {

                stmt.setDate(1, new java.sql.Date(System.currentTimeMillis()));
                stmt.setDate(2, fechaEntrega);
                stmt.setString(3, "Activo");
                stmt.setInt(4, 0);
                stmt.setInt(5, listaLibros.size());
                stmt.setInt(6, usuario.getIdUsuario());

                int registros = stmt.executeUpdate();

                if (registros == 0) {
                    JOptionPane.showMessageDialog(null, "Advertencia: No se pudo guardar el registro", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                    throw new SQLException("No se pudo obtener el ID del préstamo.");
                }

                //Obtener las llaves generadas
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int idPrestamo = rs.getInt(1);

                        String sqlPrestamoLibro = "INSERT INTO prestamolibros (idPrestamo, idLibro, fechaDevolucion) VALUES (?, ?, ?)";
                        try (PreparedStatement stmtPrestamo = conexion.prepareStatement(sqlPrestamoLibro)) {
                            //Iteración de la lista de libros que se daran en prestamo
                            for (Libro Libro : listaLibros) {
                                stmtPrestamo.setInt(1, idPrestamo);
                                stmtPrestamo.setInt(2, Libro.getIdLibro());
                                stmtPrestamo.setDate(3, fechaEntrega);
                                stmtPrestamo.executeUpdate();

                                //Actualizar copias disponibles 
                                String sqlUpdateLibro = "UPDATE libro SET copiasDisponibles = copiasDisponibles - 1 WHERE idLibro = ?";
                                try (PreparedStatement stmtUpdateLibro = conexion.prepareStatement(sqlUpdateLibro)) {
                                    stmtUpdateLibro.setInt(1, Libro.getIdLibro());
                                    stmtUpdateLibro.executeUpdate();
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Información: Registro realizado con exito", "INFORMACION", JOptionPane.WARNING_MESSAGE);

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Advertencia: No se pudo obtener el ID del prestamo", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
                        throw new SQLException("No se pudo obtener el ID del préstamo.");
                    }
                }
            }

            // Hacer commit de la transacción
            conexion.commit();

        } catch (SQLException e) {
            if (conexion != null) {
                try {
                    // Si ocurre un error, hacer rollback
                    conexion.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace(System.out);
                }
            }
            e.printStackTrace(System.out);
        } finally {
            try {
                if (conexion != null) {
                    conexion.setAutoCommit(true);
                    conexion.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
    }

    @Override
    public int updateDevolucion(Usuario idUsuario, Libro idLibro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

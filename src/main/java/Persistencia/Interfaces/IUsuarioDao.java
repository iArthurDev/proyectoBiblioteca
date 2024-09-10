/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia.Interfaces;

import Dominio.Usuario;
import java.util.List;

/**
 *
 * @author ldoar
 */
public interface IUsuarioDao {
    
    public List<Usuario> selectAll();
    
    public Usuario selectByID(Usuario usuario);
    
    public List<Usuario> selectByName(String nombre);
    
    public int insert(Usuario usuario);
    
    public int update(Usuario usuario);
    
    public int delete(Usuario usuario);
}

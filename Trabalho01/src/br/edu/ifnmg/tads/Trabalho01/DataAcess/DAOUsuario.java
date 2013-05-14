/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;

import br.edu.ifnmg.tads.Trabalho01.Classes.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauro
 */
public class DAOUsuario {
    
    private BD bd;

    public DAOUsuario() {
        bd = new BD();
    }
    
     public boolean Salvar(Usuario obj) {
        try {
            if (obj.getId() == 0) {
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into usuario(Nome,Senha) values(?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getSenha());
               
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update usuario set Nome = ?,Senha = ? where Id = ?");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getSenha());
          
                comando.setDouble(3, obj.getId());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
}
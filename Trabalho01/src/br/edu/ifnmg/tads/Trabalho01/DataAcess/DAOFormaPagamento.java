/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;

import br.edu.ifnmg.tads.Trabalho01.Classes.Pagamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mauro
 */
public class DAOFormaPagamento {
    
    private BD bd;

    public DAOFormaPagamento() {
        bd = new BD();
    }
    
     public boolean Salvar(Pagamento obj) {
        try {
            if (obj.getId() == 0) {
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into pagamentos(Nome) values(?)");
                comando.setString(1, obj.getNome());
            
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update pagamentos set Nome = ? where Id = ?");
                comando.setString(1, obj.getNome());
                comando.setDouble(2, obj.getId());
                
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;
import br.edu.ifnmg.tads.Trabalho01.Classes.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mauro
 */
public class DAOCliente {
    private BD bd;

    public DAOCliente() {
        bd = new BD();
    }

    public boolean Salvar(Cliente obj) {
        try {
            if (obj.getId() == 0) {
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into clientes(Nome,Cpf,Rg,Nascimento) values(?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getCpf());
                comando.setString(3, obj.getRg());
                java.sql.Date data = new java.sql.Date(obj.getNascimento().getTime());
                comando.setDate(4, data);                
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update clientes set Nome = ?, Cpf = ?, Rg = ?, Nascimento = ? where Id = ?");
                comando.setString(1, obj.getNome());
                comando.setString(2, obj.getCpf());
                comando.setString(3, obj.getRg());
                comando.setInt(4, obj.getId());
                java.sql.Date data = new java.sql.Date(obj.getNascimento().getTime());
                comando.setDate(5, data);
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }    
}


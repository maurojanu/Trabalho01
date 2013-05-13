/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;

import br.edu.ifnmg.tads.Trabalho01.Classes.Produto;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mauro
 */
public class DAOProduto{
    
    private BD bd;

    public DAOProduto() {
        bd = new BD();
    }
    
     public boolean Salvar(Produto obj) {
        try {
            if (obj.getId() == 0) {
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into produtos(Nome,ValorCompra,ValorVenda,Quantidade) values(?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setDouble(2, obj.getValorCompra());
                comando.setDouble(3, obj.getValorVenda());
                comando.setInt(4, obj.getQuantidade());
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update produtos set Nome = ?,ValorCompra = ?,ValorVenda = ?,Quantidade = ? where Id = ?");
                comando.setString(1, obj.getNome());
                comando.setDouble(2, obj.getValorCompra());
                comando.setDouble(3, obj.getValorVenda());
                comando.setInt(4, obj.getQuantidade());
                comando.setDouble(5, obj.getId());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduto.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
    
}
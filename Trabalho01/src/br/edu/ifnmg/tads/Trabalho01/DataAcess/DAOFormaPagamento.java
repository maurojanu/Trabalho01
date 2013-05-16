/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;

import br.edu.ifnmg.tads.Trabalho01.Classes.Pagamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
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
      public List<Pagamento> listarTodos() {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from pagamentos ");
            ResultSet resultado = comando.executeQuery();
            // Cria uma lista de produtos vazia
            List<Pagamento> pagamentos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Pagamento tmp = new Pagamento();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                
                // Pega o objeto e coloca na lista
                pagamentos.add(tmp);
            }
            return pagamentos;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
    public Pagamento Abrir(int id) {
        try {
            Pagamento pagamento = new Pagamento();

            PreparedStatement comando = bd.getConexao().prepareStatement("select * from pagamentos where Id = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();

            pagamento.setId(resultado.getInt("Id"));
            pagamento.setNome(resultado.getString("Nome"));
            

            return pagamento;

        } catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Apagar(Pagamento obj) {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("delete from pagamentos where Id = ?");
            comando.setInt(0, obj.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   public List<Pagamento> buscar(Pagamento filtro) {
        try {
            
            String sql = "select * from pagamentos ";
            String where = "";
            
            if(filtro.getNome().length() > 0){
                where = "Nome like '%"+filtro.getNome()+"%'";
            }
            
           
            
            if (filtro.getId() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Id = " + filtro.getId();
            }
            
            if(where.length() > 0){
                sql = sql + " where " + where;
            }
            
            Statement comando = bd.getConexao().createStatement();
            
            ResultSet resultado = comando.executeQuery(sql);
            // Cria uma lista de produtos vazia
            List<Pagamento> pagamentos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
               Pagamento tmp = new Pagamento();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                
                // Pega o objeto e coloca na lista
                pagamentos.add(tmp);
            }
            return pagamentos;
        } catch (SQLException ex) {
            Logger.getLogger(DAOFormaPagamento.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

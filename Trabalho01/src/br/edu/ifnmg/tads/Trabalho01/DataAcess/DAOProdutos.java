/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;

import br.edu.ifnmg.tads.Trabalho01.Classes.Produto;
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
public class DAOProdutos{
    
    private BD bd;

    public DAOProdutos() {
        bd = new BD();
    }
    
     public boolean Salvar(Produto obj) {
        try {
            if (obj.getId() == 0) {
                PreparedStatement comando = bd.getConexao().prepareStatement("insert into produtos(Nome,ValorCompra,ValorVenda,Quantidade) values(?,?,?,?)");
                comando.setString(1, obj.getNome());
                comando.setDouble(2, obj.getValorCompra());
                comando.setDouble(3, obj.getValorVenda());
                comando.setDouble(4, obj.getQuantidade());
                comando.executeUpdate();
            } else {
                PreparedStatement comando = bd.getConexao().prepareStatement("update produtos set Nome = ?,ValorCompra = ?,ValorVenda = ?,Quantidade = ? where Id = ?");
                comando.setString(1, obj.getNome());
                comando.setDouble(2, obj.getValorCompra());
                comando.setDouble(3, obj.getValorVenda());
                comando.setDouble(4, obj.getQuantidade());
                comando.setDouble(5, obj.getId());
                comando.executeUpdate();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
   public List<Produto> listarTodos() {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from produtos ");
            ResultSet resultado = comando.executeQuery();
            // Cria uma lista de produtos vazia
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Produto tmp = new Produto();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                tmp.setValorCompra(resultado.getDouble("ValorCompra"));
                tmp.setValorVenda(resultado.getDouble("ValorVenda"));
                tmp.setQuantidade(resultado.getInt("Quantidade"));
                // Pega o objeto e coloca na lista
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
    public Produto Abrir(int id) {
        try {
            Produto produto = new Produto();

            PreparedStatement comando = bd.getConexao().prepareStatement("select * from produtos where Id = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();

            produto.setId(resultado.getInt("Id"));
            produto.setNome(resultado.getString("Nome"));
            produto.setValorCompra(resultado.getDouble("ValorCompra"));
            produto.setValorVenda(resultado.getDouble("ValorVenda"));
            produto.setQuantidade(resultado.getInt("Quantidade"));

            return produto;

        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Apagar(Produto obj) {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("delete from produtos where Id = ?");
            comando.setInt(0, obj.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   public List<Produto> buscar(Produto filtro) {
        try {
            
            String sql = "select * from produtos ";
            String where = "";
            
            if(filtro.getNome().length() > 0){
                where = "Nome like '%"+filtro.getNome()+"%'";
            }
            
            if (filtro.getValorCompra() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " ValorCompra = " + filtro.getValorCompra();
            }
            if (filtro.getValorVenda() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " ValorVenda = " + filtro.getValorCompra();
            }
            if (filtro.getQuantidade() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Quantidade = " + filtro.getValorCompra();
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
            List<Produto> produtos = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Produto tmp = new Produto();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                tmp.setValorCompra(resultado.getDouble("ValorCompra"));
                tmp.setValorVenda(resultado.getDouble("ValorVenda"));
                tmp.setQuantidade(resultado.getInt("Quantidade"));
                // Pega o objeto e coloca na lista
                produtos.add(tmp);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(DAOProdutos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
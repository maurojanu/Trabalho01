/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;
import br.edu.ifnmg.tads.Trabalho01.Classes.Cliente;

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
public class DAOClientes {
    private BD bd;

    public DAOClientes() {
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
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }  
    
    public List<Cliente> listarTodos() {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from clientes ");
            ResultSet resultado = comando.executeQuery();
            // Cria uma lista de produtos vazia
            List<Cliente> clientes = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Cliente tmp = new Cliente();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                tmp.setRg(resultado.getString("Rg"));
                tmp.setCpf(resultado.getString("Cpf"));
                tmp.setNascimento(resultado.getDate("Nascimento"));
                // Pega o objeto e coloca na lista
                clientes.add(tmp);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
    public Cliente Abrir(int id) {
        try {
            Cliente cliente = new Cliente();

            PreparedStatement comando = bd.getConexao().prepareStatement("select * from clientes where Id = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();

            cliente.setId(resultado.getInt("Id"));
            cliente.setNome(resultado.getString("Nome"));
            cliente.setRg(resultado.getString("Rg"));
            cliente.setCpf(resultado.getString("Cpf"));
            cliente.setNascimento(resultado.getDate("Nascimento"));

            return cliente;

        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Apagar(Cliente obj) {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("delete from clientes where Id = ?");
            comando.setInt(0, obj.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   public List<Cliente> buscar(Cliente filtro) {
        try {
            
            String sql = "select * from clientes ";
            String where = "";
            
            if(filtro.getNome().length() > 0){
                where = "Nome like '%"+filtro.getNome()+"%'";
            }
            
           /* if (filtro.getRg().length() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Rg = " + filtro.getRg();
            }
            if (filtro.getCpf().length() > 0) {
                if(where.length() > 0) 
                    where = where + " and ";
                where = where + " Cpf = " + filtro.getRg();
            }*/
            
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
            List<Cliente> clientes = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Cliente tmp = new Cliente();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                tmp.setRg(resultado.getString("Rg"));
                tmp.setCpf(resultado.getString("Cpf"));
                tmp.setNascimento(resultado.getDate("Nascimento"));
                // Pega o objeto e coloca na lista
                clientes.add(tmp);
            }
            return clientes;
        } catch (SQLException ex) {
            Logger.getLogger(DAOClientes.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}


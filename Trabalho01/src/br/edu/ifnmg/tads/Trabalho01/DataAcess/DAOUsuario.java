/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;

import br.edu.ifnmg.tads.Trabalho01.Classes.Usuario;
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
     public List<Usuario> listarTodos() {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("select * from usuario ");
            ResultSet resultado = comando.executeQuery();
            // Cria uma lista de produtos vazia
            List<Usuario> usuarios = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Usuario tmp = new Usuario();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                
                // Pega o objeto e coloca na lista
                usuarios.add(tmp);
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
   
    public Usuario Abrir(int id) {
        try {
            Usuario usuario = new Usuario();

            PreparedStatement comando = bd.getConexao().prepareStatement("select * from usuario where Id = ?");
            comando.setInt(1, id);
            ResultSet resultado = comando.executeQuery();

            resultado.first();

            usuario.setId(resultado.getInt("Id"));
            usuario.setNome(resultado.getString("Nome"));
            

            return usuario;

        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean Apagar(Usuario obj) {
        try {
            PreparedStatement comando = bd.getConexao().prepareStatement("delete from usuario where Id = ?");
            comando.setInt(0, obj.getId());
            comando.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
   public List<Usuario> buscar(Usuario filtro) {
        try {
            
            String sql = "select * from usuario ";
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
            List<Usuario> usuarios = new LinkedList<>();
            while (resultado.next()) {
                // Inicializa um objeto de produto vazio
                Usuario tmp = new Usuario();
                // Pega os valores do retorno da consulta e coloca no objeto
                tmp.setId(resultado.getInt("Id"));
                tmp.setNome(resultado.getString("Nome"));
                
                // Pega o objeto e coloca na lista
                usuarios.add(tmp);
            }
            return usuarios;
        } catch (SQLException ex) {
            Logger.getLogger(DAOUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
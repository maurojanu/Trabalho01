/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.DataAcess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Mauro
 */

public class BD {
    
    private Connection conexao;
    
    public Connection getConexao() {
        return conexao;
    }
    
    public void setConexao(Connection Conexao){
        this.conexao = conexao;
    }
    
    public BD(){
    
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://127.0.0.1/trabalholtp3","root","12345"); 
        } catch (ClassNotFoundException ex){
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            Logger.getLogger(BD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.Classes;

import java.util.Objects;

/**
 *
 * @author marcelosa
 */
public class Usuario extends Pessoa {
  
    private String Senha;

    public Usuario() {
        Senha = "";
    }

   
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.Senha);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.Senha, other.Senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario{" + "Senha=" + Senha + '}';
    }

    

    

    
    
    
}

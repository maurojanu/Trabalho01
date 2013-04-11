/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trbalho01.Classes;

import java.util.Objects;

/**
 *
 * @author aluno
 */
public class Email {
    
    private int id;
    private String enderecos;

    public int getId() {
        return id;
    }

    public String getEnderecos() {
        return enderecos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEnderecos(String enderecos) {
        this.enderecos = enderecos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.enderecos);
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
        final Email other = (Email) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Email{" + "id=" + id + ", enderecos=" + enderecos + '}';
    }
 
    
    
}

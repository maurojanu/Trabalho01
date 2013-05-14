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
public class Pagamento {
    
    private String Nome;
    private int  Id ;
    
    public Pagamento() {
       Nome = "";
    }

    
    
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Nome);
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
        final Pagamento other = (Pagamento) obj;
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "Nome=" + Nome + '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    
   
    
    
}

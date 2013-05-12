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
    private int id;
    private String Descricao;

    public Pagamento(int id, String Descricao) {
        this.id = id;
        this.Descricao = Descricao;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.Descricao);
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
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", Descricao=" + Descricao + '}';
    }

   
    
    
}

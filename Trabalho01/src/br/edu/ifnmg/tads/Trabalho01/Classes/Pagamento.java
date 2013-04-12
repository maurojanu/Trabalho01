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
    private String Tipo;
    private String Descricao;

    public Pagamento(int id, String Tipo, String Descricao) {
        this.id = id;
        this.Tipo = Tipo;
        this.Descricao = Descricao;
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return Tipo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.Tipo);
        hash = 89 * hash + Objects.hashCode(this.Descricao);
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
        if (!Objects.equals(this.Tipo, other.Tipo)) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "id=" + id + ", Tipo=" + Tipo + ", Descricao=" + Descricao + '}';
    }
    
    
}

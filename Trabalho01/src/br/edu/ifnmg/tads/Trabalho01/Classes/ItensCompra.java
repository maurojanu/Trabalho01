/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.Classes;

import java.util.List;
import java.util.Objects;
/**
 *
 * @author marcelosa
 */
public class ItensCompra {
    private int id;
    private Produto Descricao;
    private int Quantidade;
    private List<Produto>ItensCompra;

    public ItensCompra(int id, Produto Descricao, int Quantidade, List<Produto> ItensCompra) {
        this.id = id;
        this.Descricao = Descricao;
        this.Quantidade = Quantidade;
        this.ItensCompra = ItensCompra;
    }

    public int getId() {
        return id;
    }

    public Produto getDescricao() {
        return Descricao;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public List<Produto> getItensCompra() {
        return ItensCompra;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(Produto Descricao) {
        this.Descricao = Descricao;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public void setItensCompra(List<Produto> ItensCompra) {
        this.ItensCompra = ItensCompra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.Descricao);
        hash = 53 * hash + this.Quantidade;
        hash = 53 * hash + Objects.hashCode(this.ItensCompra);
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
        final ItensCompra other = (ItensCompra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        if (this.Quantidade != other.Quantidade) {
            return false;
        }
        if (!Objects.equals(this.ItensCompra, other.ItensCompra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItensCompra{" + "id=" + id + ", Descricao=" + Descricao + ", Quantidade=" + Quantidade + ", ItensCompra=" + ItensCompra + '}';
    }
    
    
}

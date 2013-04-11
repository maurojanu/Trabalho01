/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trbalho01.Classes;

import java.util.List;
import java.util.Objects;
/**
 *
 * @author marcelosa
 */
public class ItensVenda {
    private int id;
    private Produto Descricao;
    private int Quantidade;
    private double valorUnit;
    private List<Produto> ItensVenda;

    public ItensVenda(int id, Produto Descricao, int Quantidade, double valorUnit, List<Produto> ItensVenda) {
        this.id = id;
        this.Descricao = Descricao;
        this.Quantidade = Quantidade;
        this.valorUnit = valorUnit;
        this.ItensVenda = ItensVenda;
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

    public double getValorUnit() {
        return valorUnit;
    }

    public List<Produto> getItensVenda() {
        return ItensVenda;
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

    public void setValorUnit(double valorUnit) {
        this.valorUnit = valorUnit;
    }

    public void setItensVenda(List<Produto> ItensVenda) {
        this.ItensVenda = ItensVenda;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.Descricao);
        hash = 13 * hash + this.Quantidade;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.valorUnit) ^ (Double.doubleToLongBits(this.valorUnit) >>> 32));
        hash = 13 * hash + Objects.hashCode(this.ItensVenda);
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
        final ItensVenda other = (ItensVenda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.Descricao, other.Descricao)) {
            return false;
        }
        if (this.Quantidade != other.Quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorUnit) != Double.doubleToLongBits(other.valorUnit)) {
            return false;
        }
        if (!Objects.equals(this.ItensVenda, other.ItensVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ItensVenda{" + "id=" + id + ", Descricao=" + Descricao + ", Quantidade=" + Quantidade + ", valorUnit=" + valorUnit + ", ItensVenda=" + ItensVenda + '}';
    }
    
    
}

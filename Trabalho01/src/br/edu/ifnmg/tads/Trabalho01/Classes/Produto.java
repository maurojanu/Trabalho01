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
public class Produto {
    private int Id;
    private String nome;
    private double ValorCompra;
    private double ValorVenda;
    private int Quantidade;

    public int getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public double getValorCompra() {
        return ValorCompra;
    }

    public double getValorVenda() {
        return ValorVenda;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValorCompra(double ValorCompra) {
        this.ValorCompra = ValorCompra;
    }

    public void setValorVenda(double ValorVenda) {
        this.ValorVenda = ValorVenda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.Id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.ValorCompra) ^ (Double.doubleToLongBits(this.ValorCompra) >>> 32));
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.ValorVenda) ^ (Double.doubleToLongBits(this.ValorVenda) >>> 32));
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
        final Produto other = (Produto) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ValorCompra) != Double.doubleToLongBits(other.ValorCompra)) {
            return false;
        }
        if (Double.doubleToLongBits(this.ValorVenda) != Double.doubleToLongBits(other.ValorVenda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + Id + ", nome=" + nome + ", ValorCompra=" + ValorCompra + ", ValorVenda=" + ValorVenda + '}';
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public void setValorCompra(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setValorVenda(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setQuantidade(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

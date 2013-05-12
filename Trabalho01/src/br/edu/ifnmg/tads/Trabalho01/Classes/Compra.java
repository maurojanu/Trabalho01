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
public class Compra {
    private int id;
    private double ValorTotal;
    private String Data;
    private Produto produtos;
    private int quantidade;

    public Compra(int id, double ValorTotal, String Data, Produto produtos, int quantidade) {
        this.id = id;
        this.ValorTotal = ValorTotal;
        this.Data = Data;
        this.produtos = produtos;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public String getData() {
        return Data;
    }

    public Produto getProdutos() {
        return produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public void setProdutos(Produto produtos) {
        this.produtos = produtos;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.ValorTotal) ^ (Double.doubleToLongBits(this.ValorTotal) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.Data);
        hash = 83 * hash + Objects.hashCode(this.produtos);
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
        final Compra other = (Compra) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.ValorTotal) != Double.doubleToLongBits(other.ValorTotal)) {
            return false;
        }
        if (!Objects.equals(this.Data, other.Data)) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        if (this.quantidade != other.quantidade) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", ValorTotal=" + ValorTotal + ", Data=" + Data + ", produtos=" + produtos + ", quantidade=" + quantidade + '}';
    }
    

}

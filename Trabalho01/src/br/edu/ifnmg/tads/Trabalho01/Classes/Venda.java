/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.Classes;

import java.util.Objects;
import java.util.List;
/**
 *
 * @author Mauro Sergio
 */
public class Venda {
    private int id;
    private String data;
    private double valorTotal;
    private List<ItensVenda>ItensVenda;

    
    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public double getValortotal() {
        return valorTotal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValortotal(double valortotal) {
        this.valorTotal = valortotal;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.data);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.valorTotal) ^ (Double.doubleToLongBits(this.valorTotal) >>> 32));
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
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotal) != Double.doubleToLongBits(other.valorTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venda{" + "id=" + id + ", data=" + data + ", valortotal=" + valorTotal + '}';
    }

    public List<ItensVenda> getItensVenda() {
        return ItensVenda;
    }

    public void setItensVenda(List<ItensVenda> ItensVenda) {
        this.ItensVenda = ItensVenda;
    }
    
    
}

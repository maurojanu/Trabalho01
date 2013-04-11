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
public class Compra {
    private int id;
    private double ValorTotal;
    private String Data;
    private Pagamento TipoPagamento;
    private List<Produto>ListaCompra;

    public Compra(int id, double ValorTotal, String Data, List<Produto> ListaCompra) {
        this.id = id;
        this.ValorTotal = ValorTotal;
        this.Data = Data;
        this.ListaCompra = ListaCompra;
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

    public List<Produto> getListaCompra() {
        return ListaCompra;
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

    public void setListaCompra(List<Produto> ListaCompra) {
        this.ListaCompra = ListaCompra;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.ValorTotal) ^ (Double.doubleToLongBits(this.ValorTotal) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.Data);
        hash = 29 * hash + Objects.hashCode(this.ListaCompra);
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
        if (!Objects.equals(this.ListaCompra, other.ListaCompra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", ValorTotal=" + ValorTotal + ", Data=" + Data + ", ListaCompra=" + ListaCompra + '}';
    }
    
    
    
}

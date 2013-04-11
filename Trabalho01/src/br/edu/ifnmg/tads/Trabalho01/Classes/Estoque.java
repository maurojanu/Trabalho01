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
public class Estoque {
    private int id;
    private int Quantidade;
    private List<Produto>ListaProduto;

    public Estoque(int id, int Quantidade, List<Produto> ListaProduto) {
        this.id = id;
        this.Quantidade = Quantidade;
        this.ListaProduto = ListaProduto;
    }

    public int getId() {
        return id;
    }

    public int getQuantidade() {
        return Quantidade;
    }

    public List<Produto> getListaProduto() {
        return ListaProduto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantidade(int Quantidade) {
        this.Quantidade = Quantidade;
    }

    public void setListaProduto(List<Produto> ListaProduto) {
        this.ListaProduto = ListaProduto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        hash = 23 * hash + this.Quantidade;
        hash = 23 * hash + Objects.hashCode(this.ListaProduto);
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
        final Estoque other = (Estoque) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.Quantidade != other.Quantidade) {
            return false;
        }
        if (!Objects.equals(this.ListaProduto, other.ListaProduto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estoque{" + "id=" + id + ", Quantidade=" + Quantidade + ", ListaProduto=" + ListaProduto + '}';
    }
    
    
}

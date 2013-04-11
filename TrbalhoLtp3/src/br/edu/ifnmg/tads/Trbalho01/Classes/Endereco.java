/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trbalho01.Classes;

import java.util.Objects;

/**
 *
 * @author aluno
 */
public class Endereco {
   
    private int id;
    private String rua;
    private int num;
    private String compl;
    private String bairro;
    private int cep;
    private String cidade;
    private String estado;
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCompl() {
        return compl;
    }

    public void setCompl(String compl) {
        this.compl = compl;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.rua);
        hash = 97 * hash + this.num;
        hash = 97 * hash + Objects.hashCode(this.compl);
        hash = 97 * hash + Objects.hashCode(this.bairro);
        hash = 97 * hash + this.cep;
        hash = 97 * hash + Objects.hashCode(this.cidade);
        hash = 97 * hash + Objects.hashCode(this.estado);
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
        final Endereco other = (Endereco) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.rua, other.rua)) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        if (!Objects.equals(this.compl, other.compl)) {
            return false;
        }
        if (!Objects.equals(this.bairro, other.bairro)) {
            return false;
        }
        if (this.cep != other.cep) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", rua=" + rua + ", num=" + num + ", compl=" + compl + ", bairro=" + bairro + ", cep=" + cep + ", cidade=" + cidade + ", estado=" + estado + '}';
    }
    
    
}

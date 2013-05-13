/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trabalho01.Classes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import javax.swing.JTextField;
/**
 *
 * @author Mauro Sergio
 */
public class Pessoa {
    private int Id ;
    private String Nome;
    private String Cpf;
    private String Rg;
    private Date Nascimento;
    private List<Email> emails;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;


    
    
    public int getId() {
        return Id;
    }

    public void setId(int id)throws ErroValidacaoException {
        
          this.Id = id;
       
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) throws Exception {
       

            this.Nome = nome;
       
    }

    public List<Email> getEmails() {
        return emails;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void addEmail(Email obj){
       if(!emails.contains(obj)){
           emails.add(obj);
       }
    }
    public void removeEmail(Email obj){
       if(!emails.contains(obj)){
           emails.remove(obj);
       }
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        this.Rg = rg;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public void setNascimento(Date Nascimento) {
        this.Nascimento = Nascimento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.Id;
        hash = 37 * hash + Objects.hashCode(this.Nome);
        hash = 37 * hash + Objects.hashCode(this.Cpf);
        hash = 37 * hash + Objects.hashCode(this.Rg);
        hash = 37 * hash + Objects.hashCode(this.Nascimento);
        hash = 37 * hash + Objects.hashCode(this.emails);
        hash = 37 * hash + Objects.hashCode(this.telefones);
        hash = 37 * hash + Objects.hashCode(this.enderecos);
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
        final Pessoa other = (Pessoa) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.Nome, other.Nome)) {
            return false;
        }
        if (!Objects.equals(this.Cpf, other.Cpf)) {
            return false;
        }
        if (!Objects.equals(this.Rg, other.Rg)) {
            return false;
        }
        if (!Objects.equals(this.Nascimento, other.Nascimento)) {
            return false;
        }
        if (!Objects.equals(this.emails, other.emails)) {
            return false;
        }
        if (!Objects.equals(this.telefones, other.telefones)) {
            return false;
        }
        if (!Objects.equals(this.enderecos, other.enderecos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "Id=" + Id + ", Nome=" + Nome + ", Cpf=" + Cpf + ", Rg=" + Rg + ", Nascimento=" + Nascimento + ", emails=" + emails + ", telefones=" + telefones + ", enderecos=" + enderecos + '}';
    }

    
    
    
    
}

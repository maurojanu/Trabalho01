/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.Trbalho01.Classes;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Mauro Sergio
 */
public class Cliente {
    private int id ;
    private String nome;
    private int cpf;
    private int rg; 
    private List<Email> emails;
    private List<Telefone> telefones;
    private List<Endereco> enderecos;

    public Cliente(int id, String nome, int cpf, int rg, List<Email> emails, List<Telefone> telefones, List<Endereco> enderecos) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.emails = emails;
        this.telefones = telefones;
        this.enderecos = enderecos;
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id > 1){
          this.id = id;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if(nome.length()>3 && nome.length()<250){

            this.nome = nome;
        }
        throw new Exception("Não pode haver nomes com menos de 3 letras e mais de 250 letras");
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

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + this.cpf;
        hash = 29 * hash + this.rg;
        hash = 29 * hash + Objects.hashCode(this.emails);
        hash = 29 * hash + Objects.hashCode(this.telefones);
        hash = 29 * hash + Objects.hashCode(this.enderecos);
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
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        if (this.rg != other.rg) {
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
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", emails=" + emails + ", telefones=" + telefones + ", enderecos=" + enderecos + '}';
    }
    
    
    
    
}

package com.br.biblioteca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "User_Seq", sequenceName = "User_Seq", allocationSize = 1, initialValue = 1 )
//@NamedQueries(
//       @NamedQuery(name = "Usuario.ValidaLogin", 
//                query = "SELECT  * FROM Usuario WHERE login = ?")) //aesse é o ´problema
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "User_Seq")
    private int id;
    private String nome;
    private String login;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Alan <alanjuniorestudo@gmail.com>
 */
public class Usuario {

    private int id;
    private String nome;
    private String email;
    private String usuario;
    private String senha;
    private String perfil;
    private ArrayList<Conta> contas = new ArrayList();

    public Usuario(String nome, String email, String usuario, String senha, String perfil) {
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil= perfil;
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(int id, String usuario, String senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(int id, String nome, String email, String usuario, String senha, String perfil) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
    
    
    public String toString() {

        return nome;
    }
}

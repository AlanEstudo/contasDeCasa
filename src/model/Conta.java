/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alan <alanjuniorestudo@gmail.com>
 */
public class Conta {

    private int id;
    private String nome;
    private String descricao;
    private float valor;
    private Date dataDaConta;
    private Date dataDeRegistro;
    private Usuario usuario;

    public Conta(int id, String nome, String descricao, float valor, String dataDaConta, String dataDeRegistro, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        try {
            this.dataDaConta = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataDaConta);
        } catch (ParseException ex) {
            Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.usuario = usuario;
        try {
            this.dataDeRegistro = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataDeRegistro);
        } catch (ParseException ex) {
            Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Conta(int id, String nome, String descricao, float valor, String dataDaConta, String dataDeRegistro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        try {
            this.dataDaConta = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataDaConta);
        } catch (ParseException ex) {
            Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            this.dataDeRegistro = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataDeRegistro);
        } catch (ParseException ex) {
            Logger.getLogger(Conta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataFormatadaDaConta() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataDaConta);
    }

    public String getHoraFormatadaDaConta() {
        return new SimpleDateFormat("HH:mm").format(dataDaConta);
    }

    public String getDataFormatadaDeRegistro() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataDeRegistro);
    }

    public String getHoraFormatadaDeRegistro() {
        return new SimpleDateFormat("HH:mm").format(dataDeRegistro);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataDeRegistro() {
        return dataDeRegistro;
    }

    public void setDataDeRegistro(Date dataDeRegistro) {
        this.dataDeRegistro = dataDeRegistro;
    }

    public Date getDataDaConta() {
        return dataDaConta;
    }

    public void setDataDaConta(Date dataDaConta) {
        this.dataDaConta = dataDaConta;
    }
    
    
}

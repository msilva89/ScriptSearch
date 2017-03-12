/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scriptsearch.entidy;

import java.util.List;

/**
 *
 * @author murilo.silva
 */
public class Usuario {
    
    private Long idUsuario;
    private String nmUsuario;
    private String nmLogin;
    private String dsSenha;

    private List<Ponto> listPonto;
    
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getNmLogin() {
        return nmLogin;
    }

    public void setNmLogin(String nmLogin) {
        this.nmLogin = nmLogin;
    }

    public String getDsSenha() {
        return dsSenha;
    }

    public void setDsSenha(String dsSenha) {
        this.dsSenha = dsSenha;
    }

    public List<Ponto> getListPonto() {
        return listPonto;
    }

    public void setListPonto(List<Ponto> listPonto) {
        this.listPonto = listPonto;
    }  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scriptsearch.entidy;

/**
 *
 * @author murilo.silva
 */
public class Script {
        
    private Long   idScript;
    private String dsDescricao;
    private String dsQuery;

    public Long getIdScript() {
        return idScript;
    }

    public void setIdScript(Long idScript) {
        this.idScript = idScript;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsQuery() {
        return dsQuery;
    }

    public void setDsQuery(String dsQuery) {
        this.dsQuery = dsQuery;
    }

    @Override
    public String toString() {
        return this.dsDescricao;
    }
    
    
    
}

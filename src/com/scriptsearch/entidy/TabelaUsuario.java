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
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TabelaUsuario extends AbstractTableModel {

    private List linhas;
    private String[] colunas;

    public TabelaUsuario(List listaUsuario, String[] arrayDeColunas) {
        setLinhas(listaUsuario);
        setColunas(arrayDeColunas);
    }

    @Override
    public int getColumnCount() {
        int tamanho = colunas.length;
        return tamanho;
    }

    @Override
    public int getRowCount() {
        int tamanho = linhas.size();
        return tamanho;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Object value = null;
        final Usuario c = (Usuario) linhas.get(linha);
        switch (coluna) {
            case 0:
                value = c.getNmUsuario();
                break;
            case 1:
                value = c.getNmLogin();
                break;
            case 2:
                value = c.isFlAdmin();
                break;
        }
        return value;
    }

    public Usuario getUsuario(int line) {
        Usuario usuario = (Usuario) linhas.get(line);
        return usuario;
    }

    @Override
    public boolean isCellEditable(int r, int c) {
        boolean pode = false;
        return pode;
    }

    @Override
    public String getColumnName(int num) {
        String nome = colunas[num];
        return nome;
    }

    public List getLinhas() {
        return linhas;
    }

    public void setLinhas(List linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
}

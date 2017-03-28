/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scriptsearch.dao;

import com.scriptsearch.entidy.Script;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author murilo.silva
 */
public class ScriptDao {

    private static Connection connection;

    public List<Script> findByText(String txt) {
        try {
            connection = Conexao.getConexao();
            Statement stm = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM script WHERE lower(ds_descricao) like ? order by ds_descricao");
            stmt.setString(1, "%" + txt.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();

            List<Script> retorno = new ArrayList<>();

            while (rs.next()) {
                Script script = new Script();
                script.setIdScript(rs.getLong("id_script"));
                script.setDsDescricao(rs.getString("ds_descricao"));
                script.setDsQuery(rs.getString("ds_query"));
                retorno.add(script);
            }
              stm.close();
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            Script script = new Script();
            script.setDsDescricao("Erro ao fazer a consulta no banco");
            script.setDsQuery("Entre em contato com o adm");
            return Arrays.asList(script);
        }
    }

    public List<Script> findAll() {
        try {
            connection = Conexao.getConexao();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM script order by ds_descricao");

            List<Script> retorno = new ArrayList<>();

            while (rs.next()) {
                Script script = new Script();
                script.setIdScript(rs.getLong("id_script"));
                script.setDsDescricao(rs.getString("ds_descricao"));
                script.setDsQuery(rs.getString("ds_query"));
                retorno.add(script);
            }
            stm.close();

            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            Script script = new Script();
            script.setDsDescricao("Erro ao fazer a consulta no banco");
            script.setDsQuery("Entre em contato com o adm");
            return Arrays.asList(script);
        }
    }

    public void delete(Long id) {
        try {
            connection = Conexao.getConexao();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM script WHERE id_script = ?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void inserir(Script script) {
        try {
            connection = Conexao.getConexao();
            // cria um preparedStatement
            PreparedStatement stmt = connection.prepareStatement("insert into script (ds_descricao,ds_query) values (?,?)");
            // preenche os valores
//            stmt.setString(1, “xxx ”);

            stmt.setString(1, script.getDsDescricao());
            stmt.setString(2, script.getDsQuery());
            // executa
            stmt.execute();
            stmt.close();
            System.out.println("Gravado!");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizar(Script script) {
        try {
            connection = Conexao.getConexao();
            PreparedStatement stmt = connection.prepareStatement("UPDATE script SET ds_descricao = ?, ds_query = ? WHERE id_script = ?");
            stmt.setString(1, script.getDsDescricao());
            stmt.setString(2, script.getDsQuery());
            stmt.setInt(3, script.getIdScript().intValue());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

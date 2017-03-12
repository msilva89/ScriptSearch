/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scriptsearch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author murilo.silva
 */
public class Conexao {

    private static String CLASSE = "org.postgresql.Driver";
    private static String TABELA = "suporte_script";
    private static String USUARIO = "postgres";
    private static String SENHA = "postgres";

    public static Connection getConexao() throws SQLException {
        try {
            Class.forName(CLASSE);
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5953/suporte_script", USUARIO, SENHA);
            return con;
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver JDBC. ");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erro inesperado. ");
            e.printStackTrace();;

        }
        return null;
    }
}

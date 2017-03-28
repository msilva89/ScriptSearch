/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.scriptsearch.dao;

import com.scriptsearch.entidy.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author murilo.silva
 */
public class UsuarioDao {

    private static Connection connection;

    public Usuario logar(Usuario usuario) {

        try {
            connection = Conexao.getConexao();
            Statement stm = connection.createStatement();
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE nm_login = ? and ds_senha = ?");
            stmt.setString(1, usuario.getNmLogin());
            stmt.setString(2, usuario.getDsSenha());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario user = new Usuario();
                user.setIdUsuario(rs.getLong("id_usuario"));
                user.setNmUsuario(rs.getString("nm_usuario"));
                user.setNmLogin(rs.getString("nm_login"));
                user.setDsSenha(rs.getString("ds_senha"));
                return user;
            }

            return null;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean inserirUsuario(Usuario usuario) {
        try {
            connection = Conexao.getConexao();
            // cria um preparedStatement
            PreparedStatement stmt = connection.prepareStatement("insert into usuario (nm_usuario,nm_login,ds_senha,fl_admin) values (?,?,?,?,?)");
            // preenche os valores
            stmt.setString(1, usuario.getNmUsuario());
            stmt.setString(2, usuario.getNmLogin());
            stmt.setString(3, usuario.getDsSenha());
            stmt.setBoolean(4, usuario.isFlAdmin());

            // executa
            boolean execute = stmt.execute();
            stmt.close();
            System.out.println("Gravado!");
            connection.close();
            return execute;
        } catch (SQLException e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public List<Usuario> findAll() {
        try {
            connection = Conexao.getConexao();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM usuario");

            List<Usuario> retorno = new ArrayList<>();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("id_usuario"));
                usuario.setNmUsuario(rs.getString("nm_usuario"));
                usuario.setNmLogin(rs.getString("nm_login"));
                usuario.setDsSenha(rs.getString("ds_senha"));
                usuario.setFlAdmin(rs.getBoolean("fl_admin"));
                retorno.add(usuario);
            }
            stm.close();

            return retorno;
        } catch (Exception e) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

}

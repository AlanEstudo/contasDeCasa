/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Conexao.closeConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Usuario;

/**
 *
 * @author Alan <alanjuniorestudo@gmail.com>
 */
public class UsuarioDAO {

    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Usuario usuario) throws SQLException {

        String sql = "insert into usuario(nome, email, usuario, senha)values (?,?,?,?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getEmail());
        stm.setString(3, usuario.getUsuario());
        stm.setString(4, usuario.getSenha());
        stm.execute();

    }

    public void update(Usuario usuario) throws SQLException {

        String sql = "update usuario set nome = ?, email = ?, usuario = ?, senha = ? were id = ? ";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, usuario.getNome());
        stm.setString(2, usuario.getEmail());
        stm.setString(3, usuario.getUsuario());
        stm.setString(4, usuario.getSenha());
        stm.execute();
    }

    public void insertOrUpdate(Usuario usuario) throws SQLException {
        if (usuario.getId() > 0) {
            update(usuario);
        } else {
            insert(usuario);
        }
    }

    public void delete(Usuario usuario) throws SQLException {
        String sql = "delete  from usuario were id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, usuario.getId());
        stm.execute();
    }

    public ArrayList<Usuario> selectAll() throws SQLException {
        String sql = "select * from usuario";
        PreparedStatement stm = connection.prepareStatement(sql);

        return pesquisa(stm);
    }

    private ArrayList<Usuario> pesquisa(PreparedStatement stm) throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        stm.execute();
        ResultSet rs = stm.getResultSet();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String usuario = rs.getString("usuario");
            String senha = rs.getString("senha");
            String perfil = rs.getString("perfil");

            Usuario usuarioComDadosDoBanco = new Usuario(id, nome, email, usuario, senha, perfil);
            usuarios.add(usuarioComDadosDoBanco);
        }
        return usuarios;
    }

    public Usuario selectPorId(Usuario usuario) throws SQLException {
        String sql = "select * from usuario were id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, usuario.getId());

        return pesquisa(stm).get(0);
    }

    public boolean existeNoBancoPorUsuarioESenha(Usuario usuario) throws SQLException {
        String sql = "select * from usuario where usuario = ? and senha = ?";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, usuario.getUsuario());
        stm.setString(2, usuario.getSenha());
        stm.execute();

        ResultSet resultSet = stm.getResultSet();
        return resultSet.next();
    }

    public boolean perfilAdmin(Usuario usuario) throws SQLException {
        boolean perfil = false;
        String sql = "select * from usuario where perfil = ?";

        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, usuario.getPerfil());
        stm.execute();

        ResultSet resultSet = stm.getResultSet();
        if (resultSet.next()) {
            if (resultSet.getString(6).equals("admin")) {
                 perfil = true;
            }
            perfil = false;
        }
        return perfil;

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Conta;

/**
 *
 * @author Alan <alanjuniorestudo@gmail.com>
 */
public class ContaDAO {

    private final Connection connection;

    public ContaDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Conta conta) throws SQLException {
        String sql = "insert into conta (nome, descricao, valor, dataDaConta, dataDeRgistro)values(?, ?, ?, ?, ?)";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, conta.getNome());
        stm.setString(2, conta.getDescricao());
        stm.setFloat(3, conta.getValor());
        stm.setString(4, conta.getDataFormatadaDaConta());
        stm.setString(5, conta.getDataFormatadaDeRegistro());
        stm.execute();
    }

    public void update(Conta conta) throws SQLException {

        String sql = "update conta set nome = ?, descricao = ?, valor = ?, dataDaConta = ?, dataDeRegistro were id = ? ";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, conta.getNome());
        stm.setString(2, conta.getDescricao());
        stm.setFloat(3, conta.getValor());
        stm.setString(4, conta.getDataFormatadaDaConta());
        stm.setString(5, conta.getDataFormatadaDeRegistro());
        stm.execute();
    }

    public void delete(Conta conta) throws SQLException {
        String sql = "delete  from usuario were id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, conta.getId());
        stm.execute();
    }

    public ArrayList<Conta> selectAll() throws SQLException {
        String sql = "select * from conta";
        PreparedStatement stm = connection.prepareStatement(sql);

        return pesquisa(stm);
    }

    private ArrayList<Conta> pesquisa(PreparedStatement stm) throws SQLException {
        ArrayList<Conta> contas = new ArrayList<Conta>();

        stm.execute();
        ResultSet rs = stm.getResultSet();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            String descricao = rs.getString("descricao");
            float valor = rs.getFloat("valor");
            String dataDaConta = rs.getString("dataDaConta");
            String dataDeRegistro = rs.getString("dataDeRegistro");

            Conta contaComDadosDoBanco = new Conta(id, nome, descricao, valor, dataDaConta, dataDeRegistro);
            contas.add(contaComDadosDoBanco);
        }
        return contas;
    }

    public Conta selectPorId(Conta conta) throws SQLException {
        String sql = "select * from conta were id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setInt(1, conta.getId());

        return pesquisa(stm).get(0);
    }
}

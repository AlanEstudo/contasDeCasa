/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Alan <alanjuniorestudo@gmail.com>
 */
public class Conexao {

    private static Connection conexao = null;

    public Connection getConnection() throws SQLException {
        if (conexao == null) {
            try {
                conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dbContasDeCasa", "postgres", "postgres");
            } catch (SQLException e) {
                System.out.println("Erro ao definir a conexao!\nErro:" + e.getMessage());
            }
        }
        return conexao;

    }

    public static void closeConnection() {
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexao!\nErro:" + e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println("Erro liberar o statement!\nErro:" + e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Erro liberar o ResultSet!\nErro:" + e.getMessage());
            }
        }
    }

}

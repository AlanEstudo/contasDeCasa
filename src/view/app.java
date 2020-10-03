/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Usuario;

/**
 *
 * @author Alan <alanjuniorestudo@gmail.com>
 */
public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Teste Classe DAO*/
        try {
            /*criando a conexão*/
            Connection conexao = new Conexao().getConnection();
           
            /*criando usuario dao e pasando a conexão */
            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
            
            /*criar uma lista de usuarios*/
            ArrayList<Usuario>usuarios;
            
            Usuario usuario1 = new Usuario("Administrador", "Admin@gmail.com", "admin","123456","admin");
            
            /*teste metodo insert*/
            
            usuarioDAO.perfilAdmin(usuario1);
            usuarios = usuarioDAO.selectAll();
            System.out.println(usuarios.size());
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(app.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}

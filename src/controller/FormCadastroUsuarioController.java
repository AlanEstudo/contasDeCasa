/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.FormCadastroUsuarioView;


/**
 *
 * @author Alan <alanjuniorestudo@gmail.com>
 */
public class FormCadastroUsuarioController {
    
    private FormCadastroUsuarioView view;

    public FormCadastroUsuarioController(FormCadastroUsuarioView view) {
        this.view = view;
    }
    
    public void salvaUsuario(){
        
        String nome = view.getjTextFieldNome().getText();
        String email = view.getjTextFieldEmail().getText();
        String usuario = view.getjTextFieldUsuario().getText();
        String senha = view.getjPasswordFieldSenha().getText();
        String perfil = view.
        
        Usuario usuarioCdt = new Usuario(nome, email, usuario, senha, perfil);
        
        try {
            Connection conexão = new Conexao().getConnection();
            UsuarioDAO usuarioDao = new UsuarioDAO(conexão);
            usuarioDao.insert(usuarioCdt);
            
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso!");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastroUsuarioView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        public void limparCamposFormCadastroUuario( ) {
        view.getjTextFieldNome().setText("");
        view.getjTextFieldEmail().setText("");
        view.getjTextFieldUsuario().setText("");
        view.getjPasswordFieldSenha().setText("");
    }
}

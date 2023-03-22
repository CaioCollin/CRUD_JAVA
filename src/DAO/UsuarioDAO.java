package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDAO) {

        conn = new ConexaoDAO().conectaBD();

        try {
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objUsuarioDAO.getNome_usuario());
            pstm.setString(2, objUsuarioDAO.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO " + erro);
            return null;
        }

    }

}

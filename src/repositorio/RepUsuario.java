package repositorio;

import conn.ConexaoMySql;
import static conn.ConexaoMySql.con;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class RepUsuario {

    public int retornar(String cpf, String senha) {

        con = ConexaoMySql.getConexao();
        int ret = 0;

        String sql = "select count(*) as total from usuario where cpf = '" + cpf + "' and senha = md5('" + senha + "') ";

        try {
            Statement stmtt = con.createStatement();

            ResultSet rs = stmtt.executeQuery(sql);

            while (rs.next()) {

                ret = rs.getInt("total");

            }

            ConexaoMySql.fecharConexao();

            return ret;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return ret;
        }

    }

}

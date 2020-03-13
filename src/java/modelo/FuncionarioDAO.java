
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends DataBaseDAO{
    public FuncionarioDAO() throws Exception {
    }
    
    public void inserir(Funcionario funcionario, Usuario usuario) throws Exception {
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM usuario WHERE login=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, usuario.getLogin());
        rs = pst.executeQuery();
        int usuario_id = 0;
        if (rs.next()){
            usuario_id = rs.getInt("id") ;
        }
        sql = "INSERT INTO funcionario (nome,email,cpf,telefone,usuario_id) VALUES(?,?,?,?,?)";

        pst = conn.prepareStatement(sql);
        pst.setString(1, funcionario.getNome());
        pst.setString(2, funcionario.getEmail());
        pst.setString(3, funcionario.getCpf());
        pst.setString(4, funcionario.getTelefone());
        pst.setInt(5, usuario_id);
        
        pst.execute();
    }
        
    public List<Funcionario> getLista() throws SQLException, Exception {
        try{
            List<Funcionario> lista1 = new ArrayList<Funcionario>();
            PreparedStatement pst = this.conn.prepareStatement("SELECT * from funcionario");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                //CRIANDO O OBJETO SERVICO
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setEmail(rs.getString("email"));
                f.setTelefone(rs.getString("telefone"));
                //ADICIONANDO O OBJETO A LISTA
                lista1.add(f);                
            }
            rs.close();
            pst.close();
            return lista1;
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
    
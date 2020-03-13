
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AutoCadastroDAO {

    //A conexão com o banco de dados
    private Connection connection;
    
    public AutoCadastroDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(AutoCadastro a) {
        String sql = "INSERT INTO usuario" + "(login,senha,id_perfil)" + "VALUES (?,?,?);" + 
                "INSERT INTO cliente" + "(nome,cpf,telefone,email)" + "VALUES (?,?,?,?);" +
                "INSERT INTO endereco" + "(rua,numero,bairro,cidade,referencia,estado,cep)" +
                "VALUES (?,?,?,?,?,?,?);";
        
      try {
        // prepared statement para INSERÇÃO
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        //SETA OS VALORES
        stmt.setString(1, a.getLogin());
        stmt.setString(2, a.getSenha());
        
        stmt.setInt(3, a.getPerfil().getId());        
        
        stmt.setString(4, a.getNome());
        stmt.setString(5, a.getCpf());
        stmt.setString(6, a.getTelefone());
        stmt.setString(7, a.getEmail());
        
        stmt.setString(8, a.getRua());
        stmt.setInt(9, a.getNumero());
        stmt.setString(10, a.getBairro());
        stmt.setString(11, a.getCidade());
        stmt.setString(12, a.getReferencia());
        stmt.setString(13, a.getEstado());
        stmt.setString(14, a.getCep());
        
        
        // Executa
        stmt.execute();
        stmt.close();
        
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }    
        
    }
    
}

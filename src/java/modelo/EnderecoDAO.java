package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnderecoDAO extends DataBaseDAO {
    
    public EnderecoDAO() throws Exception {
    }

    public void inserir(Endereco endereco, Cliente cliente) throws Exception {
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT id FROM cliente WHERE cpf=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, cliente.getCpf());
        rs = pst.executeQuery();
        int cliente_id = 0;
        if (rs.next()){
            cliente_id = rs.getInt("id") ;
        }
        
        sql = "INSERT INTO endereco (cep,bairro,cidade,estado,numero,referencia,rua,cliente_id) VALUES(?,?,?,?,?,?,?,?)";
        
        pst = conn.prepareStatement(sql);
        pst.setString(1, endereco.getCep());
        pst.setString(2, endereco.getBairro());
        pst.setString(3, endereco.getCidade());
        pst.setString(4, endereco.getEstado());
        pst.setInt(5, endereco.getNumero());
        pst.setString(6, endereco.getReferencia());
        pst.setString(7, endereco.getRua());
        pst.setInt(8, cliente_id);
        pst.execute();
    }
    
  
}
    
    
    

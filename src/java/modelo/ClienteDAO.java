package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO extends DataBaseDAO {
    
    public ClienteDAO() throws Exception {
    }

    public void inserir(Cliente cliente, Usuario usuario) throws Exception {
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
        sql = "INSERT INTO cliente (nome,email,cpf,telefone,usuario_id) VALUES(?,?,?,?,?)";

        pst = conn.prepareStatement(sql);
        pst.setString(1, cliente.getNome());
        pst.setString(2, cliente.getEmail());
        pst.setString(3, cliente.getCpf());
        pst.setString(4, cliente.getTelefone());
        pst.setInt(5, usuario_id);
        
        pst.execute();
    }
    
    public ArrayList<Cliente> getLista() throws Exception {
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        PreparedStatement pst;
        ResultSet rs;

        String sql = "SELECT * FROM cliente";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
            lista.add(c);
        }

        return lista;
    }
    
    public Cliente pesquisarUsuario(int id_usuario) throws Exception{
        PreparedStatement pst;
        ResultSet rs;
        Cliente c=null;

        String sql = "SELECT * FROM cliente WHERE usuario_id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id_usuario);
        
        rs = pst.executeQuery();
        if (rs.next()) {
            c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setTelefone(rs.getString("telefone"));
        }
        
        return c;

    }
    
    
}
    
    
    

    
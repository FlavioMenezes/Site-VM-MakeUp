
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicoDAO extends DataBaseDAO {
    
    public ServicoDAO() throws Exception {
        
    }
    
    public ArrayList<Servico> getLista() throws SQLException, Exception {
        try{
            ArrayList<Servico> lista = new ArrayList<Servico>();
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * from servico";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                //CRIANDO O OBJETO SERVICO
                Servico servico = new Servico();
                servico.setId(rs.getInt("id"));
                servico.setNome(rs.getString("nome"));
                servico.setTipo(rs.getString("tipo"));
                servico.setValor(rs.getFloat("valor"));
                //ADICIONANDO O OBJETO A LISTA
                lista.add(servico);                
            }

            return lista;
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        
        
    }
    
}

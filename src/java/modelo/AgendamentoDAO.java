package modelo;
import java.sql.*;
import java.util.ArrayList;
import modelo.Agendamento;


public class AgendamentoDAO extends DataBaseDAO {
    
    public AgendamentoDAO() throws Exception {        
    }
    
    public void inserir(Agendamento agendamento) throws Exception {
        PreparedStatement pst;
        String sql = "INSERT INTO agendamento (data,hora,observacao,id_funcionario,id_cliente,id_servico)"
                + " VALUES(?,?,?,?,?,?)";
        try{
        pst = conn.prepareStatement(sql);
        pst.setDate(1, new java.sql.Date(agendamento.getData().getTime()));
        pst.setTime(2, agendamento.getHora());
        pst.setString(3, agendamento.getObservacao());
        pst.setInt(4, agendamento.getFuncionario().getId());
        pst.setInt(5, agendamento.getCliente().getId());
        pst.setInt(6, agendamento.getServico().getId());
        
        pst.execute();
        pst.close();
    } catch (SQLException erro) {
        throw new RuntimeException(erro);
        }
    }      
   
    public ArrayList<Agendamento> getLista() throws SQLException, Exception {
        try {
            ArrayList<Agendamento> lista = new ArrayList<Agendamento>();
            PreparedStatement pst;
            ResultSet rs;
            String sql = "SELECT * from Agendamento";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while (rs.next()) {
                //CRIANDO O OBJETO SERVICO
                Agendamento agendamento = new Agendamento();
                agendamento.setId(rs.getInt("id"));
                agendamento.setData(rs.getDate("data"));
                agendamento.setHora(rs.getTime("hora"));
                agendamento.setObservacao(rs.getString("observacao"));
                
                
                //ADICIONANDO O OBJETO A LISTA
                lista.add(agendamento);                
            }

            return lista;
            
            
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    
    }
    
}

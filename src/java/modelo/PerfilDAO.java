package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PerfilDAO extends DataBaseDAO {

    public PerfilDAO() throws Exception {
    }

    public void inserir(Perfil perfil) throws Exception {
        PreparedStatement pst;
        String sql = "INSERT INTO perfil (perfil) VALUES(?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, perfil.getPerfil());
        pst.execute();
    }
    
        public ArrayList<Perfil> getLista() throws Exception {
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM perfil";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        MenuPerfilDAO mpdao = new MenuPerfilDAO();
        mpdao.conectar();
        while (rs.next()) {
            Perfil perfil = new Perfil();
            perfil.setId(rs.getInt("id"));
            perfil.setPerfil(rs.getString("perfil"));
            ArrayList<Menu> menu = mpdao.buscarMenu(rs.getInt("id"));
            perfil.setMenu(menu);
            lista.add(perfil);
        }
        mpdao.desconectar();
        return lista;
    }

    public Perfil procurarPerfil(Integer id) throws Exception {
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM perfil WHERE id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        MenuPerfilDAO mpdao = new MenuPerfilDAO();
        rs = pst.executeQuery();
        Perfil p = new Perfil();
        mpdao.conectar();
        ArrayList<Menu> menu = new ArrayList<Menu>();
        if (rs.next()) {
                p.setId(rs.getInt("id"));
                p.setPerfil(rs.getString("perfil"));
                menu = mpdao.buscarMenu(rs.getInt("id"));
                p.setMenu(menu);
        }
        System.out.println("chegouaqui");
        mpdao.desconectar();
        return p;
    }

    public void excluir(Integer id) throws SQLException {
        PreparedStatement pst;
        String sql = "DELETE FROM perfil WHERE id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
    }
}
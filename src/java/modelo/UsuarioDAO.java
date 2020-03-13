package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends DataBaseDAO {

    public UsuarioDAO() throws Exception {
    }

    public void inserir(Usuario usuario) throws Exception {
        PreparedStatement pst;
        String sql = "INSERT INTO usuario (login,senha,id_perfil) VALUES(?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, usuario.getLogin());
        pst.setString(2, usuario.getSenha());    
        pst.setInt(3, usuario.getPerfil().getId());
        pst.execute();
    }
   
    
    public Usuario logar(String login, String senha) throws Exception {
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM usuario WHERE login=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, login);

        rs = pst.executeQuery();
        Usuario u = new Usuario();
        PerfilDAO pdao = new PerfilDAO();
        Perfil p = new Perfil();
        System.out.println("chegouaqui");
        while (rs.next()) {
            if (senha.equals(rs.getString("senha"))) {
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                pdao.conectar();
                p = pdao.procurarPerfil(rs.getInt("id_perfil"));
                u.setPerfil(p);
                pdao.desconectar();
                
            }
        }
        return u;
    }
    
        public ArrayList<Usuario> getLista() throws Exception {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        PreparedStatement pst;
        ResultSet rs;
        PerfilDAO pDAO = new PerfilDAO();
        
        Perfil p;

        String sql = "SELECT * FROM usuario";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            pDAO.conectar();
            p = pDAO.procurarPerfil(rs.getInt("id_perfil"));
            pDAO.desconectar();
            u.setPerfil(p);
            lista.add(u);
        }

        return lista;
    }

    public Usuario procurarUsuario(Integer id) throws Exception {
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM usuario WHERE id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id);

        rs = pst.executeQuery();
        Usuario u = new Usuario();
        PerfilDAO pdao = new PerfilDAO();
        System.out.println(u);
        if (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                pdao.conectar();
                Perfil p = pdao.procurarPerfil(rs.getInt("id_perfil"));
                u.setPerfil(p);
        }
        return u;
    }

    public void excluir(Integer id) throws SQLException {
        PreparedStatement pst;
        String sql = "DELETE FROM usuario WHERE id=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        pst.execute();
    }
    
    public void AlterarUsuario(int id, Usuario usuario) throws Exception {
        PreparedStatement pst;
        String sql = "UPDATE usuario SET login=?, senha=?, id_perfil = ? WHERE id= ?";
        pst = conn.prepareStatement(sql);
        pst.setString(2, usuario.getLogin());
        pst.setString(3, usuario.getSenha());
        pst.setInt(4, usuario.getPerfil().getId());
        pst.setInt(5, id);
        pst.execute();

    }
}
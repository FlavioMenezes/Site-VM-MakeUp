/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MenuPerfilDAO extends DataBaseDAO {

    public MenuPerfilDAO() throws Exception {
    }

    public void excluir(Integer id_menu, Integer id_perfil) throws Exception {
        PreparedStatement pst;
        String sql = "DELETE FROM menu_perfil WHERE id_perfil=? AND id_menu=?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id_perfil);
        pst.setInt(2, id_menu);
        pst.execute();
    }

  /*  public ArrayList<Menu> getLista() throws Exception {
        ArrayList<Menu> lista = new ArrayList<Menu>();
        PreparedStatement pst;
        ResultSet rs;
        String sql = "SELECT * FROM menu";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setId(rs.getInt("id"));
            m.setMenu(rs.getString("menu"));
            m.setLink(rs.getString("link"));
            m.setIcone(rs.getString("icone"));
            
            lista.add(m);
        }

        return lista;
    }*/

    public void inserir(Integer id_menu, Integer id_perfil) throws Exception {
        PreparedStatement pst;
        String sql = "INSERT INTO menu_perfil VALUES(?,?)";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, id_perfil);
        pst.setInt(2, id_menu);
        pst.execute();
    }

    public ArrayList<Menu> buscarMenu(int id_perfil) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs;
        String sql = "SELECT * FROM menu_perfil WHERE id_perfil=?";
        System.out.println(sql);
        pst = conn.prepareStatement(sql);
        System.out.println(pst);
        pst.setInt(1, id_perfil);
        rs = pst.executeQuery();
        MenuDAO mdao = new MenuDAO();
        mdao.conectar();
       Menu menu = new Menu();
        ArrayList<Menu> lista = new ArrayList<Menu>();
        while(rs.next()) {
            menu = mdao.carregaPorId(rs.getInt("id_menu"));
            lista.add(menu);
        }

        mdao.desconectar();
        return lista;
    }

     public ArrayList<Menu> buscarDesvinculados(int id_perfil) throws Exception {
        PreparedStatement pst = null;
        ResultSet rs;
        String sql = "SELECT * FROM menu WHERE id NOT IN(SELECT id_menu FROM menu_perfil WHERE id_perfil=?)";
        System.out.println(sql);
        pst = conn.prepareStatement(sql);
        System.out.println(pst);
        pst.setInt(1, id_perfil);
        rs = pst.executeQuery();
        MenuDAO mdao = new MenuDAO();
        mdao.conectar();
       Menu menu = new Menu();
        ArrayList<Menu> lista = new ArrayList<Menu>();
        while(rs.next()) {
            menu = mdao.carregaPorId(rs.getInt("id"));
            lista.add(menu);
        }

        mdao.desconectar();
        return lista;
    }

   /* public void alterar(Integer id_menu, Integer id_perfil) throws Exception {
        PreparedStatement pst;
        String sql = "UPDATE menu_perfil SET id_menu=? WHERE id_perfil=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, m.getMenu());
        pst.setString(2, m.getLink());
        pst.setString(3, m.getIcone());
        pst.setInt(4, m.getId());
        pst.execute();
    }*/
    
}

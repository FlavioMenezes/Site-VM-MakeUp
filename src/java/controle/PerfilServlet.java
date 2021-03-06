
package controle;

import modelo.Menu;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import modelo.MenuPerfilDAO;
import modelo.Perfil;
import modelo.PerfilDAO;
import modelo.Usuario;
import modelo.AutoCadastro;
import modelo.UsuarioDAO;


public class PerfilServlet extends HttpServlet {

      protected void processRequest(HttpServletRequest request,
 				HttpServletResponse response)
    throws ServletException, IOException, Exception {

        PrintWriter out = response.getWriter();
        String cmd = request.getParameter( "cmd" );

        if(cmd==null)
            cmd = "principal";

        try {
            PerfilDAO pdao = new PerfilDAO();
            MenuPerfilDAO mpdao = new MenuPerfilDAO();
            RequestDispatcher rd = null;
            if(cmd.equalsIgnoreCase("listar")){
                ArrayList<Perfil> listaPerfil;
                pdao.conectar();
                listaPerfil = pdao.getLista();
                pdao.desconectar();
                request.setAttribute("perfilList", listaPerfil);
                rd = request.getRequestDispatcher( "/mostrarPerfil.jsp" );
                rd.forward( request, response );
            
            
            
            } else if( cmd.equalsIgnoreCase( "cadastrar" ) ){

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            Integer id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
            out.print(id_perfil);
            
             if (login == null || login.equals("")) {
                out.print("O campo Login deve ser preenchido!");
            } else if (senha == null || senha.equals("")) {
                out.print("O campo Senha deve ser preenchido!");
            } else {
                try {
                    Usuario u = new Usuario();
                    Perfil perfil = new Perfil();
                    UsuarioDAO uDB = new UsuarioDAO();
                    perfil.setId(id_perfil);
                    u.setLogin(login);
                    u.setSenha(senha);
                    u.setPerfil(perfil);
                    pdao.conectar();
                    uDB.conectar();
                    uDB.inserir(u);
                    uDB.desconectar();
                    rd = request.getRequestDispatcher( "ClienteServlet?cmd=listar" );
                    rd.forward( request, response );
                } catch (SQLException erro) {
                    if(erro.getErrorCode()==1062){
                       out.print("Login já existe, tente outro");
                    }
                    
                }
            }
            } else if( cmd.equalsIgnoreCase( "desvincular" ) ){
                Integer id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
                Integer id_menu = Integer.parseInt(request.getParameter("id_menu"));
                mpdao.conectar();
                mpdao.excluir(id_menu, id_perfil);
                mpdao.desconectar();
                rd = request.getRequestDispatcher( "PerfilServlet?cmd=gerenciar&id="+id_perfil );
                rd.forward( request, response );
            }else if( cmd.equalsIgnoreCase( "vincular" ) ){
                Integer id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
                Integer id_menu = Integer.parseInt(request.getParameter("id_menu"));
                mpdao.conectar();
                mpdao.inserir(id_menu, id_perfil);
                mpdao.desconectar();
                rd = request.getRequestDispatcher( "PerfilServlet?cmd=gerenciar&id="+id_perfil );
                rd.forward( request, response );

            } else if( cmd.equalsIgnoreCase( "gerenciar" ) ){
                Perfil perfil = new Perfil();
                ArrayList<Menu> listaVinculados = new ArrayList<Menu>();
                ArrayList<Menu> listaDesvinculados = new ArrayList<Menu>();
                int id = Integer.parseInt(request.getParameter("id"));
                 pdao.conectar();
                 perfil = pdao.procurarPerfil(id);
                 listaVinculados = perfil.getMenu();
                 mpdao.conectar();
                 listaDesvinculados = mpdao.buscarDesvinculados(id);
                 request.setAttribute("perfil", perfil);
                 request.setAttribute("listaVinculados", listaVinculados);
                 request.setAttribute("listaDesvinculados", listaDesvinculados);
                rd = request.getRequestDispatcher( "/gerenciarMenuPerfil.jsp" );
                rd.forward( request, response );
            } else if( cmd.equalsIgnoreCase( "atualizar" ) ){

                String login = request.getParameter("login");
                String senha = request.getParameter("senha");
                int id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
                Perfil perfil = new Perfil();
                perfil.setId(id_perfil);
                Usuario usuario = new Usuario(login, senha, perfil);
                int id = Integer.parseInt(request.getParameter("id"));
               // uDB.conectar();
               // uDB.AlterarUsuario(id, usuario);
               // uDB.desconectar();
                rd = request.getRequestDispatcher( "ClienteServlet?cmd=listar" );
                rd.forward( request, response );

            } else if( cmd.equalsIgnoreCase( "principal" ) ){

                rd = request.getRequestDispatcher( "/index.jsp" );
                rd.forward( request, response );
            }
            
        } catch( Exception e ) {
            e.printStackTrace( );
            throw new ServletException( e );
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(PerfilServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

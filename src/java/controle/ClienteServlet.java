
package controle;

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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import modelo.Perfil;
import modelo.PerfilDAO;
import modelo.Usuario;
import modelo.UsuarioDAO;

public class ClienteServlet extends HttpServlet {

      protected void processRequest(HttpServletRequest request,
 				HttpServletResponse response)
    throws ServletException, IOException, Exception {

        PrintWriter out = response.getWriter();
        String cmd = request.getParameter( "cmd" );
        HttpSession session = request.getSession();

        if(cmd==null)
            cmd = "principal";

        try {
            UsuarioDAO uDB = new UsuarioDAO();
            PerfilDAO pdao = new PerfilDAO();
            RequestDispatcher rd = null;
            if(cmd.equalsIgnoreCase("listar")){
                uDB.conectar();
                ArrayList<Usuario> lista;
                lista = uDB.getLista();
                //request.setAttribute( "clienteList", lista );
                ArrayList<Perfil> listaPerfil;
                pdao.conectar();
                listaPerfil = pdao.getLista();
                pdao.desconectar();
                //request.setAttribute("perfilList", listaPerfil);
                session.setAttribute( "clienteList", lista );
                session.setAttribute("perfilList", listaPerfil);
                response.sendRedirect("mostrarClientes.jsp");
                //rd = request.getRequestDispatcher( "/mostrarClientes.jsp" );
                //rd.forward( request, response );
            } else if( cmd.equalsIgnoreCase( "cadastrar" ) ){

            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            Integer id_perfil = Integer.parseInt(request.getParameter("id_perfil"));

            
            if (login == null || login.equals("")) {
                out.print("O campo Login deve ser preenchido!");
            } else if (senha == null || senha.equals("")) {
                out.print("O campo Senha deve ser preenchido!");
            } else {
                try {
                    Usuario u = new Usuario();
                    Perfil perfil = new Perfil();
                    perfil.setId(id_perfil);
                    u.setLogin(login);
                    u.setSenha(senha);
                    u.setPerfil(perfil);
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
            } else if( cmd.equalsIgnoreCase( "exc" ) ){
                Integer id = Integer.parseInt(request.getParameter("id"));
                uDB.conectar();
                uDB.excluir(id);
                uDB.desconectar();
                rd = request.getRequestDispatcher( "ClienteServlet?cmd=listar" );
                rd.forward( request, response );

            } else if( cmd.equalsIgnoreCase( "atu" ) ){
                int id = Integer.parseInt(request.getParameter("id"));
                uDB.conectar();
                Usuario user = uDB.procurarUsuario(id);
                uDB.desconectar();
                session.setAttribute( "usuarioAtu", user );
                rd = request.getRequestDispatcher( "/formCliCliente.jsp" );
                rd.forward( request, response );
                
                
            } else if( cmd.equalsIgnoreCase( "atualizar" ) ){

                String login = request.getParameter("login");
                String senha = request.getParameter("senha");
                int id_perfil = Integer.parseInt(request.getParameter("id_perfil"));
                Perfil perfil = new Perfil();
                perfil.setId(id_perfil);
                Usuario usuario = new Usuario(login, senha, perfil);
                int id = Integer.parseInt(request.getParameter("id"));
                uDB.conectar();
                uDB.AlterarUsuario(id, usuario);
                uDB.desconectar();
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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


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

import modelo.Servico;
import modelo.ServicoDAO;


public class ServicoServlet extends HttpServlet {

      protected void processRequest(HttpServletRequest request,
 				HttpServletResponse response)
    throws ServletException, IOException, Exception {

        PrintWriter out = response.getWriter();
        String cmd = request.getParameter( "cmd" );


        if(cmd==null)
            cmd = "principal";

        try {
            ServicoDAO sdao = new ServicoDAO();
            RequestDispatcher rd = null;
            
            if(cmd.equalsIgnoreCase("listar")){
               ArrayList<Servico> listaServico;
                sdao.conectar();
                listaServico = sdao.getLista();
                sdao.desconectar();
                request.setAttribute("servicoList", listaServico);
                rd = request.getRequestDispatcher( "/mostrarServico.jsp" );
                //rd = request.getRequestDispatcher( "/mostrarClientes.jsp" );
                rd.forward( request, response );
            }
                    
                } catch (Exception e) {
                    
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
        
        
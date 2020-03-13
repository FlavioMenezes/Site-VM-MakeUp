package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.Usuario;
import modelo.Agendamento;
import modelo.AgendamentoDAO;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Servico;
import modelo.ServicoDAO;


@WebServlet()
        public class AgendamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter( "cmd" );


        if(cmd==null)
            cmd = "principal";

        try {
            AgendamentoDAO adao = new AgendamentoDAO();
            RequestDispatcher rd = null;
            
            if(cmd.equalsIgnoreCase("listar")){
               ArrayList<Agendamento> listaAgendamento;
                adao.conectar();
                listaAgendamento = adao.getLista();
                adao.desconectar();
                request.setAttribute("agendamentoList", listaAgendamento);
                rd = request.getRequestDispatcher( "/mostrarAgendamento.jsp" );
                //rd = request.getRequestDispatcher( "/mostrarClientes.jsp" );
                rd.forward( request, response );
            }
                    
                } catch (Exception e) {
                    
                }
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // BUSCA WRITER
                PrintWriter out = response.getWriter();
         
         //Buscando os Parâmetros no REQUEST
         Date data = null;
         Time hora = null;
         Cliente cliente = null;
         Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
         if ( request.getParameter("data") != null )
         {
             try {
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                data = df.parse(request.getParameter("data"));
             } catch (Exception e) {
                 out.println("<script> alert('Erro ao efetuar agendamento');location.href='agendamento.jsp'</script> ");
                 System.out.println(e.getMessage());
                 return;
             }
         }
         
         if ( request.getParameter("hora") != null ) {
            try {
                SimpleDateFormat hf = new SimpleDateFormat("HH:mm");
                hora = new Time( hf.parse(request.getParameter("hora")).getTime() );

            } catch (Exception e) {
                out.println("<script> alert('Erro ao efetuar agendamento');location.href='agendamento.jsp'</script> ");
                 System.out.println(e.getMessage());
                 return;
            }
         }
                String observacao = request.getParameter("observacao");

         
        try {
            ClienteDAO clienteDao = new ClienteDAO();
            clienteDao.conectar();
            cliente = clienteDao.pesquisarUsuario( usuario.getId() );
            clienteDao.desconectar();
        } catch (Exception e) {
            out.println("<script> alert('Erro ao efetuar agendamento');location.href='agendamento.jsp'</script> ");
            System.out.println(e.getMessage());
            return;
        }
        
        if ( cliente == null )
        {
            out.println("<script> alert('Erro ao efetuar agendamento');location.href='agendamento.jsp'</script> ");
            return;
        }
         
         //Montando os OBJETOS 
         Funcionario funcionario = new Funcionario();
         funcionario.setId( Integer.parseInt( request.getParameter("id_funcionario") ) );
         
         Servico servico = new Servico();
         servico.setId( Integer.parseInt( request.getParameter("id_servico") ) );
         
         Agendamento agendamento = new Agendamento();
         agendamento.setData(data);
         agendamento.setHora(hora);
         agendamento.setCliente(cliente);
         agendamento.setFuncionario(funcionario);
         agendamento.setServico(servico);
         agendamento.setObservacao(observacao);


         //Salva o CADASTRO
                try {
                    
                AgendamentoDAO adao = new AgendamentoDAO();
                adao.conectar();
                adao.inserir(agendamento);
                adao.desconectar();
                // CONFIRMA CADASTRO
               out.println("<script> alert('AGENDAMENTO EFETUADO CADASTRADO COM SUCESSO!!!');location.href='agendamento.jsp';</script> ");
             
                } catch (Exception ex) {
                    Logger.getLogger(AutoCadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
         
    }
}
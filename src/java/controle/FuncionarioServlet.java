package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Funcionario;
import modelo.FuncionarioDAO;
import modelo.Perfil;
import modelo.Usuario;
import modelo.UsuarioDAO;



@WebServlet()
        public class FuncionarioServlet extends HttpServlet {
    
            protected void service(HttpServletRequest request,
                                HttpServletResponse response)
                                throws IOException, ServletException {
            
         // BUSCA WRITER
                PrintWriter out = response.getWriter();
         
         //Buscando os Parâmetros no REQUEST
         String login = request.getParameter("login");
         String senha = request.getParameter("senha");
         
         String nome = request.getParameter("nome");
         String cpf = request.getParameter("cpf");
         String telefone = request.getParameter("telefone");   
         String email = request.getParameter("email");

         
         //Montando os OBJETOS
         Usuario usuario = new Usuario();
         Funcionario funcionario = new Funcionario();

         
         usuario.setLogin(login);
         usuario.setSenha(senha);
         Perfil perfil = new Perfil();
         perfil.setId(2);
         usuario.setPerfil(perfil);
         
         funcionario.setNome(nome);
         funcionario.setCpf(cpf);
         funcionario.setTelefone(telefone);
         funcionario.setEmail(email);

         
         
         //Salva o CADASTRO
                try {
                    
                    
                UsuarioDAO udao = new UsuarioDAO();
                FuncionarioDAO cdao = new FuncionarioDAO();
                
                RequestDispatcher rd = null;
                
                udao.conectar();
                udao.inserir(usuario);
                
                cdao.conectar();
                cdao.inserir(funcionario, usuario);
                

                
                udao.desconectar();
                cdao.desconectar();

                
        
                out.println("<script> alert('FUNCIONARIO CADASTRADO COM SUCESSO!!!');location.href='mostrarClientes.jsp';</script> ");
                } catch (Exception ex) {
                    Logger.getLogger(AutoCadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
         
                
        
                
         // CONFIRMA CADASTRO
        out.println("<script> alert('FUNCIONARIO CADASTRADO COM SUCESSO!!!');</script> ");
        }
    }


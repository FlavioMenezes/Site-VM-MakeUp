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
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Endereco;
import modelo.EnderecoDAO;
import modelo.Perfil;
import modelo.Usuario;
import modelo.UsuarioDAO;



@WebServlet()
        public class AutoCadastroServlet extends HttpServlet {
    
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
         
         String rua = request.getParameter("rua");
         Integer numero = Integer.parseInt(request.getParameter("numero"));
         String bairro = request.getParameter("bairro");
         String cidade = request.getParameter("cidade");
         String referencia = request.getParameter("referencia");
         String estado = request.getParameter("estado");
         String cep = request.getParameter("cep");
         
         //Montando os OBJETOS
         Usuario usuario = new Usuario();
         Cliente cliente = new Cliente();
         Endereco endereco = new Endereco();
         
         usuario.setLogin(login);
         usuario.setSenha(senha);
         Perfil perfil = new Perfil();
         perfil.setId(3);
         usuario.setPerfil(perfil);
         
         cliente.setNome(nome);
         cliente.setCpf(cpf);
         cliente.setTelefone(telefone);
         cliente.setEmail(email);
         
         endereco.setRua(rua);
         endereco.setBairro(bairro);
         endereco.setCidade(cidade);
         endereco.setReferencia(referencia);
         endereco.setEstado(estado);
         endereco.setCep(cep);

         
         
         //Salva o CADASTRO
                try {
                    
                    
                UsuarioDAO udao = new UsuarioDAO();
                ClienteDAO cdao = new ClienteDAO();
                EnderecoDAO edao = new EnderecoDAO();
                
                RequestDispatcher rd = null;
                
                udao.conectar();
                udao.inserir(usuario);
                
                cdao.conectar();
                cdao.inserir(cliente, usuario);
                
                edao.conectar();
                edao.inserir(endereco, cliente);
                
                udao.desconectar();
                cdao.desconectar();
                edao.desconectar();
                
                rd = request.getRequestDispatcher( "login.jsp" );
                rd.forward( request, response );
                
                } catch (Exception ex) {
                    Logger.getLogger(AutoCadastroServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
         
                
        
                
         // CONFIRMA CADASTRO
        out.println("<script> alert('CLIENTE CADASTRADO COM SUCESSO!!!');</script> ");
        }
    }


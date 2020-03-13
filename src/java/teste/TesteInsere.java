
package teste;

import modelo.AutoCadastro;
import modelo.AutoCadastroDAO;
import modelo.Perfil;

public class TesteInsere {
    public static void main(String[] args) {
        
        //Pronto para Gravar
        AutoCadastro autoCadastro = new AutoCadastro();
        Perfil perfil = new Perfil();
        
         autoCadastro.setLogin("Lucas");
         autoCadastro.setSenha("1234");
         perfil.setId(3);
         
         autoCadastro.setNome("Lucas Ribeiro");
         autoCadastro.setCpf("00001414710");
         autoCadastro.setTelefone("6194949494");
         autoCadastro.setEmail("luquinha@gmail.com");
         
         autoCadastro.setRua("Street");
         autoCadastro.setBairro("Das Dores");
         autoCadastro.setCidade("Brasilia");
         autoCadastro.setReferencia("");
         autoCadastro.setEstado("DF");
         autoCadastro.setCep("70145987");
        
        // GRAVE NESSA CONEXÃO
        AutoCadastroDAO dao = new AutoCadastroDAO();
        
        //Método Elegante
        dao.adiciona(autoCadastro);
        
        System.out.println("GRAVADO!");
    }
}

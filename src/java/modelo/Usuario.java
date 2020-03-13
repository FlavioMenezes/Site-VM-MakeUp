package modelo;

import controle.ClienteServlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    
    //private int id_perfil;
    private Perfil perfil;
    // private int id_endereco;
    private Endereco endereco;
    // private int id_id_cliente;
    private Cliente cliente;
    


    public Usuario() {
    }

    public Usuario(String login, String senha, Perfil perfil) {
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

}

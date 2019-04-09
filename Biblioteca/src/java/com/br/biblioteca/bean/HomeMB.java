package com.br.biblioteca.bean;

import com.br.biblioteca.model.Usuario;
import com.br.biblioteca.dao.UsuarioDAO;
import com.br.biblioteca.model.Autor;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean

public class HomeMB {
    
    private Usuario usuario;
    private List<Usuario> listaUsuarios;


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public HomeMB(){
        UsuarioDAO dao = new UsuarioDAO();
        listaUsuarios = dao.consultaTodos();
    }
    
    public String voltar(){
        return "home";
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
    public String alterar(Usuario usuario){
        this.usuario = usuario;
        return "alterar?id="+usuario.getId();
    }
    
    public String remover(Usuario usuario){
        UsuarioDAO dao = new UsuarioDAO();
        dao.remover(usuario);
        return "home";
    }
    
}

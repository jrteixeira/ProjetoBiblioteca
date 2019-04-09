package com.br.biblioteca.bean;

import com.br.biblioteca.model.Usuario;
import com.br.biblioteca.dao.UsuarioDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ManipulaUsuarioMB {

    private Usuario usuario;
    private List<Usuario> listaUsuario;
    private String acao;

    public ManipulaUsuarioMB() {
        UsuarioDAO dao = new UsuarioDAO();
        listaUsuario = dao.consultaTodos();
        if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id") != null) {
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
            usuario = dao.consultarPorId(id);
            acao = "alterar";
        } else {
            usuario = new Usuario();
            acao = "inserir";
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public String alterar(Usuario usuario) {
        this.usuario = usuario;
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", usuario.getId());
        return "novoUsuario";
    }

    public String remover(Usuario usuario) {
        UsuarioDAO dao = new UsuarioDAO();
        dao.remover(usuario);
        return "usuario";
    }

    public String gravar() {
        UsuarioDAO dao = new UsuarioDAO();
        if (acao.equals("inserir")) {
            dao.salvar(usuario);
        } else {
            dao.atualizar(usuario);
        }
        return "usuario";
    }

    public String autenticar() {
        UsuarioDAO dao = new UsuarioDAO();
        return (dao.validaLogin(usuario)) ? "home" : "index";
    }

    public String retornaPagina() {
        return "usuario";
    }

    public String adicionarAutor() {
        return "novoUsuario";
    }

}

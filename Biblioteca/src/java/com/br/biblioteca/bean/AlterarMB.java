package com.br.biblioteca.bean;

import com.br.biblioteca.model.Usuario;
import com.br.biblioteca.dao.UsuarioDAO;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class AlterarMB {

    private int id;
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlterarMB() {
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            Map requestParams = context.getExternalContext().getRequestParameterMap();
            String idsting = (String) requestParams.get("id");
            if (idsting != null) {
                id = Integer.valueOf(idsting);
                usuario = new UsuarioDAO().consultarPorId(id);
            }

        } catch (Exception e) {

        }

    }

    public String salvar() {
        UsuarioDAO dao = new UsuarioDAO();
        dao.atualizar(usuario);
        return "home";
    }

}

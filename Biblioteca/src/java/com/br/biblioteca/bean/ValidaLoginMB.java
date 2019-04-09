
package com.br.biblioteca.bean;

import com.br.biblioteca.model.Usuario;
import com.br.biblioteca.dao.UsuarioDAO;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ValidaLoginMB {
    
    private String Login;
    private String Senha;

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
    
    public String validaLogin (String login, String senha){
        UsuarioDAO dao = new UsuarioDAO();
//            if(dao.ValidaLogin(login, senha)){
//                return "Inicio";
//    }else{
//                return "senha ou login errados";
//            }}
        
        Usuario user = dao.consultarPorLogin(login);
        if (user == null){
            FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login não existe",
                                       "Erro no Login!"));
                return "";
        }
        if(!user.getSenha().equals(senha)){
                FacesContext.getCurrentInstance().addMessage(
                           null,
                           new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha invalida",
                                       "Erro no Login!"));
        }
        return "Inicio";
    }
}

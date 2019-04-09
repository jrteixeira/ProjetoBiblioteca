package com.br.biblioteca.bean;

import com.br.biblioteca.dao.AutorDAO;
import com.br.biblioteca.model.Autor;
import com.br.biblioteca.model.Livro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ManipulaAutorMB {
  
    private Autor autor;
    private String acao;
    private List<Autor> listaAutores;
    
    public ManipulaAutorMB(){
        AutorDAO dao = new AutorDAO();
        listaAutores = dao.consultaTodos();
        if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id") != null) {
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
            autor = dao.consultarPorId(id);
            acao = "alterar";
        } else {
            autor = new Autor();
            acao = "inserir";
        }
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }


    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    
    
   

    public List<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(List<Autor> listaUsuarios) {
        this.listaAutores = listaUsuarios;
    }
    
    public String alterar(Autor autor){
        this.autor = autor;
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", autor.getId());
        return "novoAutor";
    }
    
    /*public AutorMB() throws IOException {
        if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id") != null) {
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
            AutorDAO dao = new AutorDAO();
            autor = dao.consultarPorId(id);
        }
        FacesContext.getCurrentInstance().getExternalContext().redirect("ManipulaAutor");
    }*/
    
    public String remover(Autor autor){
        AutorDAO dao = new AutorDAO();
        dao.remover(autor);
        return "autor";
    }
    
    public String gravar (){
        AutorDAO dao = new AutorDAO();
         if(acao.equals("inserir"))
        dao.salvar(autor);
         else
             dao.atualizar(autor);
        return "autor";
    }
    
    public String retornaPagina(){
    return "autor";
    }
    
    public String adicionarAutor() {
        return "novoAutor";
    }
    
}

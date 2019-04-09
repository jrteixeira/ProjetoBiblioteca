package com.br.biblioteca.bean;

import com.br.biblioteca.dao.LivroDAO;
import com.br.biblioteca.model.Livro;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ManipulaLivroMB {

    private Livro livro;
    private List<Livro> listaLivros;
    private String acao;

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public ManipulaLivroMB() {
        LivroDAO dao = new LivroDAO();
        listaLivros = dao.consultaTodos();
        if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id") != null) {
            int id = (int) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
            livro = dao.consultarPorId(id);
            acao = "alterar";
        } else {
            livro = new Livro();
            acao = "inserir";
        }
    }

    public String alterar(Livro livro) {
        this.livro = livro;
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", livro.getId());
        return "novoLivro";
    }

    public String remover(Livro livro) {
        LivroDAO dao = new LivroDAO();
        dao.remover(livro);
        return "livro";
    }

    public String gravar() {
        LivroDAO dao = new LivroDAO();
        if(acao.equals("inserir"))
            dao.salvar(livro);
        else
            dao.atualizar(livro);
        return "livro";
    }

    public String retornaPagina() {
        return "livro";
    }

    public String adicionarLivro() {
        return "novoLivro";
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public List<Livro> getListaLivros() {
        return listaLivros;
    }

    public void setListaLivros(List<Livro> listaLivros) {
        this.listaLivros = listaLivros;
    }

}

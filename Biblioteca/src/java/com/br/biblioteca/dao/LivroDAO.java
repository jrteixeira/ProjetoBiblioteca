package com.br.biblioteca.dao;

import com.br.biblioteca.model.Livro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class LivroDAO {

    public Livro salvar(Livro livro) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(livro);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return livro;
    }

    public void atualizar(Livro livro) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(livro);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remover(Livro livro) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            Query q = em.createQuery("delete from Livro u where u.id = :id");
            q.setParameter("id", livro.getId());
            em.getTransaction().begin();
            //usuario = em.find(Livro.class, usuario.getNome());
            //em.remove(usuario);
            q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
        }
    }

    public List<Livro> consultaTodos() {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        List<Livro> livros;
        try {
            //Query q = em.createNamedQuery("Livro.ConsultarTodos");
            Query q = //em.createQuery("SELECT l FROM Livro l");
            em.createQuery("SELECT u FROM Livro u");
            livros = q.getResultList();
        } catch (Exception e) {
            livros = new ArrayList();
        } finally {
            em.close();
        }
        return livros;
    }

    public Livro consultarPorId(int id) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            Query query = em.createQuery("select u from Livro u where u.id = :id");
            query.setParameter("id", id);
            return (Livro) query.getSingleResult();
        } finally {
            em.close();
        }
    }
}

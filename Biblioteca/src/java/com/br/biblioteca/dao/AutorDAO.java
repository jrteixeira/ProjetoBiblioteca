package com.br.biblioteca.dao;
import com.br.biblioteca.model.Autor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class AutorDAO {

    public Autor salvar(Autor autor) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return autor;
    }

    public void atualizar(Autor autor) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {

            em.getTransaction().begin();
            em.merge(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remover(Autor autor) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            Query q = em.createQuery("delete from Autor u where u.id = :id");
            q.setParameter("id", autor.getId());
            em.getTransaction().begin();
            //usuario = em.find(Usuario.class, usuario.getNome());
            //em.remove(usuario);
            q.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
        }
    }

    public List<Autor> consultaTodos() {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        List<Autor> autores;
        try {
            //Query q = em.createNamedQuery("Usuario.ConsultarTodos");
            Query q = em.createQuery("SELECT u FROM Autor u");
            autores = q.getResultList();
        } catch (Exception e) {
            autores = new ArrayList();
        } finally {
            em.close();
        }
        return autores;
    }

    public Autor consultarPorId(int id) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            Query query = em.createQuery("select u from Autor u where u.id = :id");
            query.setParameter("id", id);
            return (Autor) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public Autor consultarPorLogin(String nome) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();

        try {
//         Query q  =  em.createQuery("SELECT * from Usuario u where u.login = :loginPessoa");
//                         q.setParameter("loginPessoa", loginPessoa);
            Autor user = em.find(Autor.class, nome);

            return user;
        } finally {
            em.close();
        }
    }

    
}

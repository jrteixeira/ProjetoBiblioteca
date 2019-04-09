package com.br.biblioteca.dao;

import com.br.biblioteca.bean.ManipulaUsuarioMB;
import com.br.biblioteca.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UsuarioDAO {

    public Usuario salvar(Usuario usuario) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        } finally {
            em.close();
        }
        return usuario;
    }

    public void atualizar(Usuario usuario) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {

            em.getTransaction().begin();
            em.merge(usuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void remover(Usuario usuario) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            Query q = em.createQuery("delete from Usuario u where u.id = :id");
            q.setParameter("id", usuario.getId());
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

    public List<Usuario> consultaTodos() {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        List<Usuario> usuarios;
        try {
            //Query q = em.createNamedQuery("Usuario.ConsultarTodos");
            Query q = em.createQuery("SELECT u FROM Usuario u");
            usuarios = q.getResultList();
        } catch (Exception e) {
            usuarios = new ArrayList();
        } finally {
            em.close();
        }
        return usuarios;
    }

    public Usuario consultarPorId(int id) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();
        try {
            Query query = em.createQuery("select u from Usuario u where u.id = :id");
            query.setParameter("id", id);
            return (Usuario) query.getSingleResult();
        } finally {
            em.close();
        }
    }

    public Usuario consultarPorLogin(String loginPessoa) {
        EntityManager em = BibliotecaEntityMananger.getEntityManager();

        try {
//         Query q  =  em.createQuery("SELECT * from Usuario u where u.login = :loginPessoa");
//                         q.setParameter("loginPessoa", loginPessoa);
            Usuario user = em.find(Usuario.class, loginPessoa);

            return user;
        } finally {
            em.close();
        }
    }

    public boolean validaLogin(Usuario usuario) {
        try {
            EntityManager em = BibliotecaEntityMananger.getEntityManager();
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login ");
            q.setParameter("login", usuario.getLogin());
            Usuario temp = (Usuario) q.getSingleResult();

            return (temp.getSenha().equals(usuario.getSenha()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}

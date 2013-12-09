/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model.DAO;

import com.embarcou.model.Viacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author clovis
 */
public class ViacaoDAO {
    
    
    public static void inserir(Viacao viacao){ 
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(viacao);
        em.getTransaction().commit();
    
    }
    
    public static List<Viacao> findAll(){      
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        return em.createNamedQuery("Viacao.findAll").getResultList();
    }
    
    public static List<Viacao> findbyName(String nome){  
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        return em.createNamedQuery("Viacao.findByNome").setParameter("nome", nome).getResultList();
    }
    
    public static List<Viacao> findbyId(int id){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        return em.createNamedQuery("Viacao.findById").setParameter("id", id).getResultList();
    }

    public static boolean removeById(int id) {
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        List<Viacao> viacao =  em.createNamedQuery("Viacao.findById").setParameter("id", id).getResultList();
        
        if(viacao.isEmpty()){
            return false;        
        }
        
        em.getTransaction().begin();
        em.remove(viacao.get(0));
        em.getTransaction().commit();
        
        return true;
    }

    public static void update(int id, String nome, String telefone, String site, String cnpj) { 
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        em.getTransaction().begin();
        
        Viacao viacao = em.find(Viacao.class, id);
        
        viacao.setCnpj(cnpj);
        viacao.setNome(nome);
        viacao.setLogo("/upload/logo.gif");
        viacao.setSite(site);
        viacao.setTelefone(telefone);
        
        em.merge(viacao);
        em.getTransaction().commit();
    }

    public static void inserir(String nome, String cnpj, String telefone, String site) {      
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        Viacao viacao = new Viacao();
        
        viacao.setCnpj(cnpj);
        viacao.setNome(nome);
        viacao.setLogo("/upload/logo.gif");
        viacao.setSite(site);
        viacao.setTelefone(telefone);
        
        em.getTransaction().begin();
        em.persist(viacao);
        em.getTransaction().commit();        
        
    }
    
}

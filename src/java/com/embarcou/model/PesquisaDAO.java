/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author clovis
 */
public class PesquisaDAO {

    public static boolean insert(Pesquisa pesquisa) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(pesquisa);
        em.getTransaction().commit();
        
        return true;
    
    }
    
    public static List<Pesquisa> findAllOrderBy(int page){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Pesquisa.findAllOrderBy");
        
        List <Pesquisa> pesquisas = query.setFirstResult(10*(Math.abs(page-1)))
                                          .setMaxResults(10).getResultList();
        
        return pesquisas;
    
    }
    
    
}

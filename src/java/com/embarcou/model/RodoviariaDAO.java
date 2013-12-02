/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author clovis
 */
public class RodoviariaDAO {
    
    public static List<Rodoviaria> findAll(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        
        return em.createNamedQuery("Rodoviaria.findAll").getResultList();
    }
    
    public static List<Rodoviaria> findByNome(String nome){
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        
        return em.createNamedQuery("Rodoviaria.findByNome").setParameter("nome", nome).getResultList();
    }
    
    public static boolean insert(String nome){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        Rodoviaria rodoviaria = new Rodoviaria(nome);

        em.getTransaction().begin();
        em.persist(rodoviaria);
        em.getTransaction().commit();
        return true;
    }
    
    public static boolean remove(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        
        List<Rodoviaria> rodoviaria =  em.createNamedQuery("Rodoviaria.findById").setParameter("id", id).getResultList();
        
        if(rodoviaria.isEmpty()){
            return  false;
        }
        
        em.getTransaction().begin();
        em.remove(rodoviaria.get(0));
        em.getTransaction().commit();
        
        return true;
    
    }
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model.DAO;

import com.embarcou.model.Rodoviaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author clovis
 */
public class RodoviariaDAO {
    
    public static List<Rodoviaria> findAll() {
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        return em.createNamedQuery("Rodoviaria.findAll").getResultList();
    }
    
    public static List<Rodoviaria> findByNome(String nome) {  
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        return em.createNamedQuery("Rodoviaria.findByNome").setParameter("nome", nome).getResultList();
    }
    
    public static boolean insert(String nome){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        Rodoviaria rodoviaria = new Rodoviaria(nome);

        em.getTransaction().begin();
        em.persist(rodoviaria);
        em.getTransaction().commit();
        return true;
    }
    
    public static boolean remove(int id){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
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

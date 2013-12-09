package com.embarcou.model.DAO;

import com.embarcou.model.Trecho;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author clovis
 */
public class TrechoDAO {
    
    public static List<Trecho> findAll(){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        return em.createNamedQuery("Trecho.findAll").getResultList();
        
    }
    
    public static List<Trecho> findById(int id){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        return em.createNamedQuery("Trecho.findById").setParameter("id", id).getResultList();
        
    }
    
    public static boolean removeById(int id){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        List <Trecho> trechos = em.createNamedQuery("Trecho.findById").setParameter("id", id).getResultList();
        
        if(trechos.isEmpty()){
            return false;
        }
        
        Trecho trecho = trechos.get(0);
        
        em.getTransaction().begin();
        em.remove(trecho);
        em.getTransaction().commit();
        
        return true;
        
    }
    
    public static List<Trecho> findDayOfWeek(int diaSemana, String origem, String destino){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        List<Trecho> trechos = null;
            
        switch(diaSemana){
            case 1:
                   trechos = em.createNamedQuery("Trecho.findByOrigemDestinoDomingo").setParameter("origem", origem).setParameter("destino", destino).getResultList();
                    break;
            case 2:
                   trechos = em.createNamedQuery("Trecho.findByOrigemDestinoSegunda").setParameter("origem", origem).setParameter("destino", destino).getResultList();
                   break;
             case 3:
                   trechos = em.createNamedQuery("Trecho.findByOrigemDestinoTerca").setParameter("origem", origem).setParameter("destino",destino).getResultList();
                   break;
             case 4:
                   trechos = em.createNamedQuery("Trecho.findByOrigemDestinoQuarta").setParameter("origem", origem).setParameter("destino",destino).getResultList();
                   break;
            case 5:
                   trechos = em.createNamedQuery("Trecho.findByOrigemDestinoQuinta").setParameter("origem", origem).setParameter("destino", destino).getResultList();
                   break;
            case 6:
                   trechos = em.createNamedQuery("Trecho.findByOrigemDestinoSexta").setParameter("origem", origem).setParameter("destino", destino).getResultList();
                    break;
            case 7:
                   trechos = em.createNamedQuery("Trecho.findByOrigemDestinoSabado").setParameter("origem", origem).setParameter("destino", destino).getResultList();
                   break;
            default:
                return null;

        }
        return trechos;
        
    }
    
    
    
    
}

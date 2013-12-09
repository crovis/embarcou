package com.embarcou.model.DAO;

import com.embarcou.model.Pesquisa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author clovis
 */
public class PesquisaDAO {

    public static boolean insert(Pesquisa pesquisa) {
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(pesquisa);
        em.getTransaction().commit();
        
        return true;
    
    }
    
    public static List<Pesquisa> findAllOrderBy(int page){
        EntityManager em = Persistence.createEntityManagerFactory("EmbarcouPU").createEntityManager();
        Query query = em.createNamedQuery("Pesquisa.findAllOrderBy");
        
        List <Pesquisa> pesquisas = query.setFirstResult(10*(Math.abs(page-1)))
                                          .setMaxResults(10).getResultList();
        
        return pesquisas;
    
    }
    
    
}

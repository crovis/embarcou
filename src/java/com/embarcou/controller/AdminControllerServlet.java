/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.controller;

import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.embarcou.model.Pesquisa;
import com.embarcou.model.PesquisaDAO;

/**
 *
 * @author clovis
 */

public class AdminControllerServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        listarPesquisas(request, response);
        
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void listarPesquisas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        int page = 1;
        if(request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        
        Query query = em.createNamedQuery("Pesquisa.findAllOrderBy");
        
        List <Pesquisa> pesquisas = query.setFirstResult(10*(Math.abs(page-1)))
                                          .setMaxResults(10).getResultList();*/
        
        List <Pesquisa> pesquisas = PesquisaDAO.findAllOrderBy(page);

        request.setAttribute("pesquisas", pesquisas);
        request.setAttribute("page", page);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
}

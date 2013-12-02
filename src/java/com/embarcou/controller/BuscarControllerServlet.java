/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.embarcou.model.Pesquisa;
import com.embarcou.model.PesquisaDAO;
import com.embarcou.model.Rodoviaria;
import com.embarcou.model.RodoviariaDAO;
import com.embarcou.model.Trecho;
import com.embarcou.model.TrechoDAO;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author clovis
 */
public class BuscarControllerServlet extends HttpServlet {

    
    /*  
     * Adicionar origem, destino e data a tabela pesquisa do banco.
     * Executar busca.
     * 
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        
        //response.setContentType("text/html;charset=UTF-8");        

        inserirPesquisa(request, response);

        request.getRequestDispatcher("buscar.jsp").forward(request, response);
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscarControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BuscarControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private void inserirPesquisa(HttpServletRequest request, HttpServletResponse response) throws ParseException{
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        int dia_semana;
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date data = formatter.parse(request.getParameter("data"));
        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        
        
        Pesquisa pesquisa = new Pesquisa(origem, destino, data);
        PesquisaDAO.insert(pesquisa);
        
        request.setAttribute("pesquisa", pesquisa);

        List <Rodoviaria> rodoviarias = RodoviariaDAO.findAll();
        request.setAttribute("rodoviarias", rodoviarias);

        //Busca rodoviaria
        List <Rodoviaria> rodoviaria_origem = RodoviariaDAO.findByNome(origem);
        List <Rodoviaria> rodoviaria_destino =  RodoviariaDAO.findByNome(destino);
        
        if(rodoviaria_origem.isEmpty() || rodoviaria_destino.isEmpty()){
            //DO NOTHING
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(pesquisa.getData());
            dia_semana = c.get(Calendar.DAY_OF_WEEK);

            List<Trecho> trechos = TrechoDAO.findDayOfWeek(dia_semana, rodoviaria_origem.get(0).getNome(), rodoviaria_destino.get(0).getNome());
            request.setAttribute("trechos", trechos);
            
        }
    }
}

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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.embarcou.model.Pesquisa;
import com.embarcou.model.DAO.PesquisaDAO;
import com.embarcou.model.Rodoviaria;
import com.embarcou.model.DAO.RodoviariaDAO;
import com.embarcou.model.Trecho;
import com.embarcou.model.DAO.TrechoDAO;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
        int dia_semana;
        Date data;
        String origem, destino;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        
        origem = request.getParameter("origem");
        destino = request.getParameter("destino");
        
        if(!expressionData(request.getParameter("data")))
        {
            data = new Date();
        } else {
            data = formatter.parse(request.getParameter("data"));
        }

        
        Pesquisa pesquisa = new Pesquisa(origem, destino, data);
        PesquisaDAO.insert(pesquisa);
        
        request.setAttribute("pesquisa", pesquisa);

        List <Rodoviaria> rodoviarias = RodoviariaDAO.findAll();
        request.setAttribute("rodoviarias", rodoviarias);

        //Busca rodoviaria
        List <Rodoviaria> rodoviaria_origem = RodoviariaDAO.findByNome(origem);
        List <Rodoviaria> rodoviaria_destino =  RodoviariaDAO.findByNome(destino);
        
        if(rodoviaria_origem.isEmpty() || rodoviaria_destino.isEmpty()) {
            request.setAttribute("msgBusca", "<div class=\"alert alert-warning\">Origem e destino não encontradas</div>");
        } else {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    Date data_atual = new Date();
            
            System.out.println(dateFormat.format(data_atual) + "    " +  dateFormat.format(pesquisa.getData()));
            
            if(pesquisa.getData().before(data_atual) && !dateFormat.format(pesquisa.getData()).equals(dateFormat.format(data_atual))){
                request.setAttribute("msgBusca", "<div class=\"alert alert-warning\">Não foram encontradas passagens para esse dia</div>");
            } else {
                
                Calendar c = Calendar.getInstance();
                c.setTime(pesquisa.getData());
                dia_semana = c.get(Calendar.DAY_OF_WEEK);
                List<Trecho> trechos = TrechoDAO.findDayOfWeek(dia_semana, rodoviaria_origem.get(0).getNome(), rodoviaria_destino.get(0).getNome());
                request.setAttribute("trechos", trechos);
                if(trechos.isEmpty()){
                    request.setAttribute("msgBusca", "<div class=\"alert alert-warning\">Não foram encontradas passagens para esse dia</div>");
                }
            }
        }
    }
    
    private boolean expressionData(String data){
        
        return data.matches("\\d{2}-\\d{2}-\\d{4}");
        
    }
}

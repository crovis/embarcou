/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.controller;

import com.embarcou.model.Rodoviaria;
import com.embarcou.model.DAO.RodoviariaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clovis
 */
public class RodoviariaControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        request.setCharacterEncoding("UTF-8");
        
         if (request.getRequestURI().endsWith("/nova")) 
         {
            request.getRequestDispatcher("nova.jsp").forward(request, response);
         } 
         else if (request.getRequestURI().endsWith("/edit"))
         {
             listarRodoviaria(request, response);
         } 
         else if (request.getRequestURI().endsWith("/delete"))
         {
             removerRodoviaria(request, response);
             listarRodoviaria(request, response);
         } 
         else if (request.getRequestURI().endsWith("/nova_rodoviaria"))
         {
             inserirRodoviaria(request, response);
         } else 
         {
             listarRodoviaria(request, response);
         }
        
    }
    
    private void listarRodoviaria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        List <Rodoviaria> rodoviarias = RodoviariaDAO.findAll();
        
        request.setAttribute("rodoviarias", rodoviarias);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    private void inserirRodoviaria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nome = new String(request.getParameter("nome").getBytes(
               "iso-8859-1"), "UTF-8");
        
        if(nome.equals("")  == false){
            RodoviariaDAO.insert(nome);
            request.setAttribute("insertSuccess", "<div class=\"alert alert-success\">Rodoviária inserida com sucesso!</div>");
        }
        
        listarRodoviaria(request, response);
        
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

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Regras de negócios da classe Rodoviaria";
    }

    private void editarRodoviaria(HttpServletRequest request, HttpServletResponse response) {
       
       // @TODO 
        
    }

    private void removerRodoviaria(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(RodoviariaDAO.remove(id) == true){
            request.setAttribute("removeSuccess", "<div class=\"alert alert-success\">Rodoviária removida com sucesso!</div>");
        } else {
            request.setAttribute("removeSuccess", "<div class=\"alert alert-danger\">Rodoviária nao removida!</div>");
        }
    }
}

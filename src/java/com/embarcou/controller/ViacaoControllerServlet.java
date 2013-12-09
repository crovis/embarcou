package com.embarcou.controller;

import com.embarcou.model.Viacao;
import com.embarcou.model.DAO.ViacaoDAO;
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

public class ViacaoControllerServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (request.getRequestURI().endsWith("/nova"))
        {
            request.getRequestDispatcher("nova.jsp").forward(request, response);
        } 
        else if(request.getRequestURI().endsWith("/nova_viacao"))
        {
            novaViacao(request, response);
        } 
        else if (request.getRequestURI().endsWith("/delete"))
        {
            removerViacao(request, response);
            listarViacoes(request, response);
        } 
        else if (request.getRequestURI().endsWith("/edit"))
        {
            editarViacao(request, response);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } 
         else if (request.getRequestURI().endsWith("/edit_viacao"))
        {
            System.out.println("@ENTROU");
            atualizarViacao(request, response);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } 
        else
        {
            listarViacoes(request, response);
        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
    
    private void novaViacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        System.out.println("ETA PORRA");
        String nome = request.getParameter("nome");
        String cnpj = request.getParameter("cnpj_data");
        String telefone = request.getParameter("telefone");
        String site = request.getParameter("site");
        
        System.out.println("TESTE DE VALORES" + nome + cnpj + telefone + site);
        
        ViacaoDAO.inserir(nome, cnpj, telefone, site);
        
        listarViacoes(request, response);
    }
    
    private void listarViacoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{        
        
        List <Viacao> viacoes = ViacaoDAO.findAll();
        request.setAttribute("viacoes", viacoes);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void removerViacao(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        
        if(ViacaoDAO.removeById(id)){
            request.setAttribute("removeSucces", "<div class=\"alert alert-success\"><p>Viação removida com sucesso!</p></div>");       
        } else {
            request.setAttribute("removeSucces", "<div class=\"alert alert-danger\"><p>Viação não removida!</p></div>");       
        }
    }

    private void editarViacao(HttpServletRequest request, HttpServletResponse response) {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        List<Viacao> viacao = ViacaoDAO.findbyId(id);
        
        if(viacao.isEmpty()){
            request.setAttribute("msgEdit", "<div class=\"alert alert-success\"><p>Viação removida com sucesso!</p></div>");
            return;
        }
        
        request.setAttribute("viacao", viacao.get(0));
    }

    private void atualizarViacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String cnpj = (request.getParameter("cnpj").toString()).replaceAll("\\D+","");
        String telefone = request.getParameter("telefone");
        String site = request.getParameter("site");
        int id = Integer.parseInt(request.getParameter("id_viacao"));
        
        ViacaoDAO.update(id, nome, telefone, site, cnpj);
        
        listarViacoes(request, response);
        
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.controller;

import com.embarcou.model.Rodoviaria;
import com.embarcou.model.RodoviariaDAO;
import com.embarcou.model.Trecho;
import com.embarcou.model.TrechoDAO;
import com.embarcou.model.Viacao;
import com.embarcou.model.ViacaoDAO;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clovis
 */
public class TrechoControllerServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if (request.getRequestURI().endsWith("/nova")) {
            novoTrecho(request, response);
            request.getRequestDispatcher("nova.jsp").forward(request, response);
        } else if (request.getRequestURI().endsWith("/novo_trecho"))
        {
            adicionarTrecho(request, response);
            listarTrechos(request, response);
        } else if(request.getRequestURI().endsWith("/delete"))
        {
            removerTrechos(request, response);
            listarTrechos(request, response);
        }
        else {
            listarTrechos(request, response);
        }
    }
    
    private void novoTrecho(HttpServletRequest request, HttpServletResponse response){
        
        List <Rodoviaria> rodoviarias = RodoviariaDAO.findAll();
        request.setAttribute("rodoviarias", rodoviarias);
        
        // Busca lista de viações
        List <Viacao> viacoes = ViacaoDAO.findAll();
        request.setAttribute("viacoes", viacoes);
        
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
        return "Servlet para CRUD da classe Trecho";
    }

    private void listarTrechos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        List<Trecho> trechos = TrechoDAO.findAll();
        request.setAttribute("trechos", trechos);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void adicionarTrecho(HttpServletRequest request, HttpServletResponse response)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmbarcouPU");
        EntityManager em = emf.createEntityManager();
        
        int segunda=0, terca=0, quarta=0, quinta=0, sexta=0, sabado=0, domingo=0;
        
        String origem_nome="";
        String destino_nome="";
        String viacao_nome="";
        try {
            origem_nome = new String(request.getParameter("origem").getBytes(
            "iso-8859-1"), "UTF-8");
            destino_nome = new String(request.getParameter("destino").getBytes(
                    "iso-8859-1"), "UTF-8");
            viacao_nome = new String(request.getParameter("viacao").getBytes(
                    "iso-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TrechoControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        String string_preco = request.getParameter("preco");
        Float preco = Float.parseFloat(string_preco.replaceAll(",", "."));
        
        if(request.getParameter("segunda") != null)
            segunda = 1;
        if(request.getParameter("terca")!= null)
            terca = 1;
        if(request.getParameter("quarta")!= null)
            quarta = 1;
        if(request.getParameter("quinta")!= null)
            quinta = 1;
        if(request.getParameter("sexta")!= null)
            sexta = 1;
        if(request.getParameter("sabado")!= null)
            sabado = 1;
        if(request.getParameter("domingo")!= null)
            domingo = 1;
        
        List<Rodoviaria> origens = RodoviariaDAO.findByNome(origem_nome);
        List<Rodoviaria> destinos =  RodoviariaDAO.findByNome(destino_nome);
        List<Viacao> viacoes = ViacaoDAO.findbyName(viacao_nome);
        
        if(origens.isEmpty() || destinos.isEmpty() || viacoes.isEmpty()){
            return;
        }
        
        //System.out.println("LOG GERAL DO SERVLET " + destino_nome + origem_nome + viacao_nome);
        
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        System.out.println("HORARIOS " + request.getParameter("saida") + request.getParameter("chegada"));
        
        String saida = request.getParameter("saida");
        String chegada = request.getParameter("chegada");

        Trecho trecho = new Trecho();
        trecho.setRodoviariaDestino(destinos.get(0));
        trecho.setRodoviariaOrigem(origens.get(0));
        trecho.setViacao(viacoes.get(0));
        trecho.setDomingo(domingo);
        trecho.setSegunda(segunda);
        trecho.setTerca(terca);
        trecho.setQuarta(quarta);
        trecho.setQuinta(quinta);
        trecho.setSexta(sexta);
        trecho.setSabado(sabado);
        trecho.setChegada(chegada);
        trecho.setSaida(saida);
        trecho.setPreco(preco);
        em.getTransaction().begin();
        em.persist(trecho);
        em.getTransaction().commit();
    }

    private void removerTrechos(HttpServletRequest request, HttpServletResponse response) {
       int id = Integer.parseInt(request.getParameter("id"));
        
        boolean success = TrechoDAO.removeById(id);
        
        if(success){
            request.setAttribute("removeMsg", "<div class=\"alert alert-success\"><p>Trecho removido com sucesso!</p></div>");
        } else {
             request.setAttribute("removeMsg", "<div class=\"alert alert-danger\"><p>Trecho não foi removido!</p></div>");
        }  
       
    }
}

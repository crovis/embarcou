<%@page import="com.embarcou.model.Pesquisa"%>
<%@page import="java.util.Date"%>
<%@page import="java.lang.String"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <%@include file="../include/header.jsp" %>
        <title>Embarcou - O melhor preço de passagem</title>
    </head>
    <body>
        <div class="container">
            <header class="navbar navbar-default navbar-fixed-top bs-docs-nav" role="banner">
                <div class="container">
                    <div class="navbar-header">
                        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".bs-navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a href="#" class="navbar-brand">Embarcou</a>
                    </div>
                    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Trechos<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="trechos/">Listar</a></li>
                                    <li><a href="trechos/nova">Nova</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Rodoviárias<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="rodoviarias/">Listar</a></li>
                                    <li><a href="rodoviarias/nova">Nova</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Viacões<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="viacoes/">Listar</a></li>
                                    <li><a href="viacoes/nova">Nova</a></li>
                                </ul>
                            </li>
                            
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="ajuda">Ajuda</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </header>
            <div class="header-image">
                <div class="headline">
                    <div class="container">
                            <div class="row">
                                <div class="page-header">
                                    <h2>Buscas recentes</h2>
                                </div>
                                <table class="table table-hover text-left table-bordered">
                                    <thead>
                                        <tr>
                                            <th>
                                                #
                                            </th>
                                            <th>
                                                Data
                                            </th>
                                            <th>
                                                Origem
                                            </th>
                                            <th>
                                                Destino
                                            </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        
                                        <c:forEach var="pesquisa" items="${requestScope.pesquisas}">
                                            <tr>
                                        <td>${pesquisa.id}</td><td><fmt:formatDate value="${pesquisa.data}" type="date" dateStyle="long" timeStyle="long"/></td> <td> ${pesquisa.origem} </td> <td>${pesquisa.destino}</td>
                                            </tr>
                                            </c:forEach>
                                    </tbody>
                                </table>
                                <ul class="pagination">
                                    <c:forEach begin="1" end="5" var="i">
                                        <c:choose>
                                            <c:when test="${requestScope.page eq i}">
                                                <li class="active"><span>${i}</span></li>
                                            </c:when>
                                            <c:otherwise>
                                                    <li><a href="?page=${i}">${i}</a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                              </ul>
                            </div>
                        </div>
                </div>
            </div>

            <!-- /header-image -->

            <!-- FOOTER -->
            
            <hr>
            <div class="footer">
                <div class="container">
                    <footer>
                        <p>
                            Copyleft &copy; Embarcou.com 2013 &middot; <a href="${ pageContext.request.contextPath }/equipe">Equipe :) </a>
                        </p>
                    </footer>
                </div>
            </div>

        </div>

        <script src="${ pageContext.request.contextPath }/js/bootstrap.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap3-typeahead.js"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.js" charset="UTF-8"></script>
        <script src="${ pageContext.request.contextPath }/js/bootstrap-datepicker.pt-BR.js" charset="UTF-8"></script>
    </body>

</html>
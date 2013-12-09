<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="utf-8">

        <!-- Bootstrap core CSS -->
        <link href="${ pageContext.request.contextPath }/css/bootstrap.css" type="text/css"  rel="stylesheet">
        <link href="${ pageContext.request.contextPath }/css/one-page-wonder.css" type="text/css" rel="stylesheet">
        <link href="${ pageContext.request.contextPath }/css/datepicker.css" type="text/css" rel="stylesheet">

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

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
                        <a href="../../admin" class="navbar-brand">Embarcou</a>
                    </div>
                    <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
                        <ul class="nav navbar-nav">
                            <li class="dropdown active">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Trechos<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Listar</a></li>
                                    <li><a href="nova">Nova</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Rodoviaria<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="../rodoviarias/">Listar</a></li>
                                    <li><a href="../rodoviarias/nova">Nova</a></li>
                                </ul>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Viacões<b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="../viacoes/">Listar</a></li>
                                    <li><a href="../viacoes/nova">Nova</a></li>
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
                            <div class="page-header text-left">
                                <h1>Trechos <small>Lista de trechos</small></h1>
                            </div>
                            ${requestScope.removeMsg}
                            <table class="table table-hover text-left table-bordered">
                                <thead>
                                    <tr>
                                        <th>
                                            #
                                        </th>
                                        <th>
                                            Origem
                                        </th>
                                        <th>
                                            Destino
                                        </th>
                                        <th>
                                            Viacao
                                        </th>
                                        <th>
                                            Segunda
                                        </th>
                                        <th>
                                            Terça
                                        </th>
                                        <th>
                                            Quarta
                                        </th>
                                        <th>
                                            Quinta
                                        </th>
                                        <th>
                                            Sexta
                                        </th>
                                        <th>
                                            Sábado
                                        </th>
                                        <th>
                                            Domingo
                                        </th>
                                        <th>
                                            Saída
                                        </th>
                                        <th>
                                            Chegada
                                        </th>
                                        <th>
                                            Preço
                                        </th>
                                        <th>
                                            Apagar
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <fmt:setLocale value="pt_BR"/>
                                    <c:forEach var="trecho" items="${requestScope.trechos}">
                                        <tr>
                                            <td>${trecho.id}</td>
                                            <td>${trecho.rodoviariaOrigem.nome}</td>
                                            <td>${trecho.rodoviariaDestino.nome}</td>
                                            <td>${trecho.viacao.nome}</td>
                                            <td>
                                                <c:if test="${trecho.segunda eq 1}">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${trecho.terca eq 1}">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${trecho.quarta eq 1}">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${trecho.quinta eq 1}">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${trecho.sexta eq 1}">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${trecho.sabado eq 1}">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </c:if>
                                            </td>
                                            <td>
                                                <c:if test="${trecho.domingo eq 1}">
                                                    <span class="glyphicon glyphicon-ok"></span>
                                                </c:if>
                                            </td>
                                            <td>${trecho.saida}</td>
                                            <td>${trecho.chegada}</td>
                                            <td><strong><fmt:formatNumber value="${trecho.preco}" type="currency"/></strong></td>
                                            <td><a class="btn btn-danger btn-xs" href="delete?id=${trecho.id}">Deletar</a></td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

            <!-- /header-image -->
            <hr>
            <!-- FOOTER -->
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